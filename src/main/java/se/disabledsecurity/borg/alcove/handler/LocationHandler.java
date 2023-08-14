package se.disabledsecurity.borg.alcove.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.disabledsecurity.borg.alcove.model.external.Location;
import se.disabledsecurity.borg.alcove.service.RequestHandler;

@Component
public class LocationHandler {
	private final RequestHandler requestHandler;
	public LocationHandler(RequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}

	public Mono<ServerResponse> handleFileUpload(ServerRequest serverRequest) {
		Flux<Location> locations = requestHandler.handleRequest(serverRequest);

		return ServerResponse.ok().body(BodyInserters.fromPublisher(locations, Location.class));


	}
}
