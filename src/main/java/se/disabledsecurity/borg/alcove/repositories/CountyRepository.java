package se.disabledsecurity.borg.alcove.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import se.disabledsecurity.borg.alcove.entity.County;

import java.util.List;
import java.util.UUID;

public interface CountyRepository extends ListCrudRepository<County, UUID> {
	County findByNameIgnoreCase(String name);
	@Query("SELECT c FROM County c JOIN c.municipalities m WHERE m.name = :municipality")
	County findCountyByMunicipality(@Param("municipality") String municipality);
}