package se.disabledsecurity.borg.alcove.service;

import org.springframework.web.multipart.MultipartFile;
import se.disabledsecurity.borg.alcove.model.external.Location;

import java.util.List;

public interface FileService  {
	List<Location> handleFileUpload(MultipartFile file);
}
