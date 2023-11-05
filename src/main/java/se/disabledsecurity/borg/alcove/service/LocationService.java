package se.disabledsecurity.borg.alcove.service;

import org.springframework.web.multipart.MultipartFile;
import se.disabledsecurity.borg.alcove.model.internal.Locations;

public interface LocationService {
	Locations handleFileUpload(MultipartFile file);
}
