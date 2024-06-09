package se.disabledsecurity.borg.alcove.service;

import se.disabledsecurity.borg.alcove.model.internal.County;
import se.disabledsecurity.borg.alcove.model.internal.Location;

import java.util.List;

public interface DatabaseService {
	List<County> saveAllCounties(List<Location> locations);
	County searchCountyByName(String name);
	List<County> searchMunicipalitiesByName(String name);
}
