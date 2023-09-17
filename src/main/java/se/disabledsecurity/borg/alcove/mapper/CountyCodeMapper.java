package se.disabledsecurity.borg.alcove.mapper;

import java.util.function.ToIntFunction;


public class CountyCodeMapper {
	private CountyCodeMapper() {}
	public static final ToIntFunction<String> map = s -> Integer.parseInt(s.substring(0, 2).trim());

}
