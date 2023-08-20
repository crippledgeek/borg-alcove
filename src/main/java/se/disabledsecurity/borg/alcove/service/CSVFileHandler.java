package se.disabledsecurity.borg.alcove.service;

import io.vavr.control.Try;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import se.disabledsecurity.borg.alcove.model.external.Location;

import java.io.InputStream;

import static se.disabledsecurity.borg.alcove.functions.Functions.csvMapper;
import static se.disabledsecurity.borg.alcove.functions.Functions.locationsSchema;

@Service
public class CSVFileHandler implements FileHandler {
	@Override
	public Flux<Location> handleFileUpload(InputStream inputStream) {
		return Try.withResources(() -> inputStream,
								 () -> csvMapper.get().readerFor(Location.class)
									   .with(locationsSchema.get())
									   .<Location>readValues(inputStream))
				.of((i, objectMappingIterator) -> objectMappingIterator.readAll())
				.map(Flux::fromIterable)
				.getOrElseGet(throwable -> Flux.empty());


	}
}
