package se.disabledsecurity.borg.alcove.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import se.disabledsecurity.borg.alcove.mapper.LocationMapper;
import se.disabledsecurity.borg.alcove.model.internal.Location;

import java.util.List;

@Service
public class MultipartLocationService implements LocationService {
	private final FileService fileService;

	public MultipartLocationService(FileService fileService) {
		this.fileService = fileService;
	}

	@Override
	public List<Location> handleFileUpload(MultipartFile file) {
		return LocationMapper.map(fileService.handleFileUpload(file));
	}
}