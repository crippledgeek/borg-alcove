package se.disabledsecurity.borg.alcove.mapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MunicipalityCodeMapperTest {

	@Test
	void map() {
		assertEquals(14, MunicipalityCodeMapper.map.applyAsInt("0114"));
	}

}