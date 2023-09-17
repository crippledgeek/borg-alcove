package se.disabledsecurity.borg.alcove.mapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountyCodeMapperTest {

	@Test
	void map() {
		assertEquals(1, CountyCodeMapper.map.applyAsInt("0114"));
	}

}