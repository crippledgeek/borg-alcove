package se.disabledsecurity.borg.alcove.mapper;

import se.disabledsecurity.borg.alcove.functions.Functions;
import se.disabledsecurity.borg.alcove.model.external.Location;
import se.disabledsecurity.borg.alcove.model.internal.County;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountyMapper {
	private CountyMapper() {}
	private static final Function<Stream<Location>, Map<String, List<Location>>> groupLocationByCounty = locationStream -> locationStream
			.collect(Collectors.groupingBy(Location::county));


	public static List<County> map(Stream<Location> locationStream) {
		return groupLocationByCounty
				.apply(locationStream)
				.entrySet()
				.stream().
				map(entry -> County.builder()
						.name(Functions.trim.apply(entry.getKey()))
						.code(CountyCodeMapper.map.applyAsInt(entry.getValue().get(0).code()))
						.municipalities(MunicipalityMapper.map(entry.getValue()))
						.build())
				.toList();
	}
}
