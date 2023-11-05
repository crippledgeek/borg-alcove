package se.disabledsecurity.borg.alcove.mapper;

import se.disabledsecurity.borg.alcove.model.internal.Location;
import se.disabledsecurity.borg.alcove.model.internal.Locations;

import java.util.List;

public class LocationsMapper {
	private LocationsMapper() {}

	public static Locations map(List<Location> locations) {
		return Locations.from(locations);
	}
}
