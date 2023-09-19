package se.disabledsecurity.borg.alcove.service;

import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import se.disabledsecurity.borg.alcove.mapper.LocationMapper;
import se.disabledsecurity.borg.alcove.model.external.Location;

import java.util.Collections;
import java.util.List;

import static se.disabledsecurity.borg.alcove.functions.Functions.csvMapper;
import static se.disabledsecurity.borg.alcove.functions.Functions.locationsSchema;

@Slf4j
@Service
public class CSVFileService implements FileService {

	@Override
	public List<Location> handleFileUpload(MultipartFile file) {
		return Try
				.withResources(file::getInputStream,
							   () -> csvMapper
									   .get()
									   .readerFor(Location.class)
									   .with(locationsSchema.get())
									   .<Location>readValues(file.getInputStream()))
				.of((i, objectMappingIterator) -> objectMappingIterator.readAll())
				.onSuccess(LocationMapper::map)
				.onFailure(e -> log.error("Failed to parse CSV file", e))
				.toJavaList()
				.stream()
				.flatMap(List::stream)
				.toList();
	}
}

