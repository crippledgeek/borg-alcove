package se.disabledsecurity.borg.alcove.service;

import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import se.disabledsecurity.borg.alcove.model.external.Location;

public interface RequestHandler {
	Flux<Location> handleRequest(ServerRequest serverRequest);
}
