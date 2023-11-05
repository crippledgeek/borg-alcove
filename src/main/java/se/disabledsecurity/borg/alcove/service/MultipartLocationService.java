package se.disabledsecurity.borg.alcove.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import se.disabledsecurity.borg.alcove.functions.Functions;
import se.disabledsecurity.borg.alcove.mapper.LocationMapper;
import se.disabledsecurity.borg.alcove.model.internal.Location;
import se.disabledsecurity.borg.alcove.model.internal.Locations;

import java.util.List;

@Service
public class MultipartLocationService implements LocationService {
	private final FileService fileService;
	private final DatabaseService databaseService;

	public MultipartLocationService(FileService fileService, DatabaseService databaseService) {
		this.fileService = fileService;
		this.databaseService = databaseService;
	}

	@Override
	public Locations handleFileUpload(MultipartFile file) {
		List<Location> locations = LocationMapper.map.apply(fileService.handleFileUpload(file));
		var counties = databaseService.saveAllCounties(locations);
		return Functions.map.apply(counties);

	}
}