package se.disabledsecurity.borg.alcove.mapper;

import se.disabledsecurity.borg.alcove.model.internal.County;
import se.disabledsecurity.borg.alcove.model.internal.Location;

import java.util.List;
import java.util.function.Function;

public class LocationMapper {
	private LocationMapper() {
	}


	public static final Function<List<se.disabledsecurity.borg.alcove.model.external.Location>, List<se.disabledsecurity.borg.alcove.model.internal.Location>> map = locations ->
		CountyMapper
				.map(locations.stream())
				.stream()
				.map(county -> County
						.builder()
						.name(county.name())
						.municipalities(county.municipalities())
						.code(county.code())
						.build())
				.map(county -> se.disabledsecurity.borg.alcove.model.internal.Location
						.builder()
						.county(county)
						.build())
				.toList();
	}

