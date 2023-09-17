package se.disabledsecurity.borg.alcove.service;

import org.springframework.web.multipart.MultipartFile;
import se.disabledsecurity.borg.alcove.model.internal.Location;

import java.util.List;

public interface LocationService {
	List<Location> handleFileUpload(MultipartFile file);
}
