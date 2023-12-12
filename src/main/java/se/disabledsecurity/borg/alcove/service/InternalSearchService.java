package se.disabledsecurity.borg.alcove.service;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;
import se.disabledsecurity.borg.alcove.functions.Functions;
import se.disabledsecurity.borg.alcove.model.internal.Locations;

import java.util.stream.Stream;
@Observed
@Service
public class InternalSearchService implements SearchService {
	private final DatabaseService databaseService;

	public InternalSearchService(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	@Override
	public Locations searchCountiesByName(String name) {
		return Functions.map.apply(
				Stream.of(databaseService.
				searchCountyByName(name))
				.toList());
	}

	@Override
	public Locations searchMunicipalitiesByName(String name) {
		return Functions.map.apply(
				Stream.of(databaseService.
				searchMunicipalitiesByName(name))
				.toList());
	}
}
