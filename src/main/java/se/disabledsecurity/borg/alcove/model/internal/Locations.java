package se.disabledsecurity.borg.alcove.model.internal;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public record Locations(List<Location> locations) {
	private static final List<Location> EMPTY_LIST = List.of();
	public static Locations from(List<Location> locations) {
		return new Locations(locations);
	}

	public boolean isEmpty() {
		return locations == null || locations.isEmpty() || locations.stream().allMatch(location -> location.county() == null);
	}
	public int size() {
		return isEmpty() ?
			   0 :
			   locations.size();
	}
	public List<Location> locations() {
		return locations.isEmpty() ?
			   EMPTY_LIST :
			   locations;
	}

	public Stream<Location> stream() {
		return locations.stream();
	}
}