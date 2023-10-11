package se.disabledsecurity.borg.alcove.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import se.disabledsecurity.borg.alcove.mapper.LocationMapper;
import se.disabledsecurity.borg.alcove.model.internal.Location;

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
	public List<Location> handleFileUpload(MultipartFile file) {
		List<Location> locations = LocationMapper.map(fileService.handleFileUpload(file));
		var counties = databaseService.saveAllCounties(locations);
		return LocationMapper.mapToFrontendModel(counties);
	}
}