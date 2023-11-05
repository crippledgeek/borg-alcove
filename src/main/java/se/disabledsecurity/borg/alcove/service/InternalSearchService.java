package se.disabledsecurity.borg.alcove.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import se.disabledsecurity.borg.alcove.functions.Functions;
import se.disabledsecurity.borg.alcove.model.internal.Locations;

import java.util.stream.Stream;

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
		return null;
	}
}
