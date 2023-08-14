package se.disabledsecurity.borg.alcove.service;

import reactor.core.publisher.Flux;
import se.disabledsecurity.borg.alcove.model.external.Location;

import java.io.InputStream;

public interface FileHandler {
	Flux<Location> handleFileUpload(InputStream inputStream);
}
