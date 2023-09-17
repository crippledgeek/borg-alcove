package se.disabledsecurity.borg.alcove.mapper;

import java.util.function.ToIntFunction;

public class MunicipalityCodeMapper {
	private MunicipalityCodeMapper() {}
	public static final ToIntFunction<String> map = s -> Integer.parseInt(s.substring(2, 4).trim());
}
