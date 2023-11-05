package se.disabledsecurity.borg.alcove.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.disabledsecurity.borg.alcove.mapper.DatabaseCountyMapper;
import se.disabledsecurity.borg.alcove.mapper.DatabaseMunicipalityMapper;
import se.disabledsecurity.borg.alcove.model.internal.County;
import se.disabledsecurity.borg.alcove.model.internal.Location;
import se.disabledsecurity.borg.alcove.repositories.CountyRepository;
import se.disabledsecurity.borg.alcove.repositories.MunicipalityRepository;

import java.util.List;

@Service
public class PostgresService implements DatabaseService {
	private final DatabaseCountyMapper databaseCountyMapper;
	private final DatabaseMunicipalityMapper databaseMunicipalityMapper;
	private final CountyRepository countyRepository;
	private final MunicipalityRepository municipalityRepository;

	public PostgresService(DatabaseCountyMapper databaseCountyMapper, DatabaseMunicipalityMapper databaseMunicipalityMapper, CountyRepository countyRepository, MunicipalityRepository municipalityRepository) {
		this.databaseCountyMapper = databaseCountyMapper;
		this.databaseMunicipalityMapper = databaseMunicipalityMapper;
		this.countyRepository = countyRepository;
		this.municipalityRepository = municipalityRepository;
	}

	@Override
	@Transactional
	public List<se.disabledsecurity.borg.alcove.model.internal.County> saveAllCounties(List<Location> locations) {
		var counties = locations
				.stream()
				.map(Location::county)
				.map(databaseCountyMapper::toEntity)
				.toList();

		return countyRepository
				.saveAll(counties)
				.stream()
				.map(databaseCountyMapper::toDto)
				.toList();


	}

	@Override
	@Transactional
	public County searchCountyByName(String name) {
		return databaseCountyMapper.toDto(countyRepository
				.findByNameContainingIgnoreCase(name));

	}

	@Override
	@Transactional
	public County searchMunicipalitiesByName(String name) {
		return databaseCountyMapper.toDto(countyRepository
				.findCountyByMunicipality(name));
	}

}