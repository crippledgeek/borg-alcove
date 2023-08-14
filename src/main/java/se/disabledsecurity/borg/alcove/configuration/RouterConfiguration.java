package se.disabledsecurity.borg.alcove.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import se.disabledsecurity.borg.alcove.handler.LocationHandler;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

@Configuration(proxyBeanMethods = false)
public class RouterConfiguration {
	private final LocationHandler locationHandler;

	public RouterConfiguration(LocationHandler locationHandler) {
		this.locationHandler = locationHandler;
	}

	@Bean
	public RouterFunction<ServerResponse> routes() {
		return RouterFunctions
				.route()
				.POST("/api/locations", contentType(MULTIPART_FORM_DATA), locationHandler::handleFileUpload)
				.build();

	}
}
