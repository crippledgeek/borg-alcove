package se.disabledsecurity.borg.alcove.mapper;

import se.disabledsecurity.borg.alcove.model.internal.County;
import se.disabledsecurity.borg.alcove.model.internal.Location;

import java.util.List;

public class LocationMapper {
	private LocationMapper() {
	}

	public static List<se.disabledsecurity.borg.alcove.model.internal.Location> map(List<se.disabledsecurity.borg.alcove.model.external.Location> locations) {
		return CountyMapper
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

	public static List<Location> mapToFrontendModel(List<County> counties) {
		return counties
				.stream()
				.map(county -> se.disabledsecurity.borg.alcove.model.internal.Location
						.builder()
						.county(county)
						.build())
				.toList();
	}
}
