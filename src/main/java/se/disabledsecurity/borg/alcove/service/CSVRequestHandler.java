package se.disabledsecurity.borg.alcove.service;

import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import se.disabledsecurity.borg.alcove.model.external.Location;

import java.util.function.Function;

@Service
public class CSVRequestHandler implements RequestHandler{

	public static final String FILE_REQUEST_KEY = "locations";

	private  final FileHandler fileHandler;

	public CSVRequestHandler(FileHandler fileHandler) {
		this.fileHandler = fileHandler;
	}

	@Override
	public Flux<Location> handleRequest(ServerRequest serverRequest) {
		return serverRequest
				.multipartData()
				.publishOn(Schedulers.boundedElastic())
				.map(stringPartMultiValueMap -> stringPartMultiValueMap
						.toSingleValueMap()
						.get(FILE_REQUEST_KEY))
				.map(Part::content)
				.flatMapMany(dataBufferFlux -> dataBufferFlux)
				.publishOn(Schedulers.boundedElastic())
				.map(dataBuffer -> fileHandler.handleFileUpload(dataBuffer.asInputStream(true)))
				.flatMap(Function.identity())
				.log();
	}
}
