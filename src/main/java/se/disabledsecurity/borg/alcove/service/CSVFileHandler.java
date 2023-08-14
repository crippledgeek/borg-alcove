package se.disabledsecurity.borg.alcove.service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import se.disabledsecurity.borg.alcove.model.external.Location;

import java.io.InputStream;

@Service
public class CSVFileHandler implements FileHandler {
	@Override
	public Flux<Location> handleFileUpload(InputStream inputStream) {
		var schema = CsvSchema
				.builder()
				.addColumn("county")
				.addColumn("municipality")
				.addColumn("code")
				.build()
				.withSkipFirstDataRow(true)
				.withColumnSeparator(';');


		CsvMapper mapper = new CsvMapper();

		return Try
				.withResources(() -> inputStream,
							   () -> mapper
									   .readerFor(Location.class)
									   .with(schema)
									   .<Location>readValues(inputStream))
				.of((i, objectMappingIterator) -> objectMappingIterator.readAll())
				.map(Flux::fromIterable)
				.getOrElseGet(throwable -> Flux.empty());


	}
}
