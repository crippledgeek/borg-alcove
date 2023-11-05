package se.disabledsecurity.borg.alcove.service;

import se.disabledsecurity.borg.alcove.model.internal.Locations;

public interface SearchService {
	Locations searchCountiesByName(String name);
	Locations searchMunicipalitiesByName(String name);
}
