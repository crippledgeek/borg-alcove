package se.disabledsecurity.borg.alcove.repositories;

import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.disabledsecurity.borg.alcove.entity.County;

import java.util.UUID;

import static org.hibernate.jpa.AvailableHints.HINT_CACHEABLE;


@Repository
public interface CountyRepository extends ListCrudRepository<County, UUID> {
	County findByNameIgnoreCase(String name);
	@Query("SELECT c FROM County c JOIN c.municipalities m WHERE m.name = :municipality")
	County findCountyByMunicipality(@Param("municipality") String municipality);

	//https://stackoverflow.com/questions/25362540/like-query-in-spring-jparepository
	@QueryHints(value = @QueryHint(name = HINT_CACHEABLE, value = "true"))
	County findByNameContainingIgnoreCase(String name);

}