package se.disabledsecurity.borg.alcove.mapper;

import se.disabledsecurity.borg.alcove.functions.Functions;
import se.disabledsecurity.borg.alcove.model.external.Location;
import se.disabledsecurity.borg.alcove.model.internal.Municipality;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MunicipalityMapper {
	private MunicipalityMapper() {}
	public static Set<Municipality> map(List<Location> source) {
		return source
				.stream().map(l -> Municipality.builder()
						.name(Functions.trim.apply(l.municipality()))
						.code(MunicipalityCodeMapper.map.applyAsInt(l.code()))
						.build())
				.collect(Collectors.toSet());
	}
}
