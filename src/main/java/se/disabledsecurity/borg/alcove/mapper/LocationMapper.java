package se.disabledsecurity.borg.alcove.mapper;

import se.disabledsecurity.borg.alcove.model.external.Location;
import se.disabledsecurity.borg.alcove.model.internal.County;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LocationMapper {
	private LocationMapper() {
	}

	public static List<se.disabledsecurity.borg.alcove.model.internal.Location> map(List<se.disabledsecurity.borg.alcove.model.external.Location> locations) {
		var counties = CountyMapper
				.map(locations.stream())
				.stream()
				.map(county -> County
						.builder()
						.name(county.name())
						.municipalities(county.municipalities())
						.code(county.code())
						.build())
				.collect(Collectors.toCollection(() -> new ArrayList<>(locations.size())));

		return counties
				.stream()
				.map(county -> se.disabledsecurity.borg.alcove.model.internal.Location
						.builder()
						.county(county)
						.build())
				.toList();
	}
	}
