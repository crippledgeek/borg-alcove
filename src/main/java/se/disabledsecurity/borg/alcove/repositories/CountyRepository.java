package se.disabledsecurity.borg.alcove.repositories;

import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import se.disabledsecurity.borg.alcove.entity.County;

import java.util.List;
import java.util.UUID;

import static org.hibernate.jpa.HibernateHints.HINT_CACHEABLE;


@Repository
public interface CountyRepository extends QueryByExampleExecutor<County>, ListCrudRepository<County, UUID> {
    @QueryHints(value = @QueryHint(name = HINT_CACHEABLE, value = "true"))
    @Query("SELECT c FROM County c JOIN FETCH c.municipalities m WHERE m.name LIKE %:municipalityName%")
    List<County> findByMunicipalityNameContaining(String municipalityName);
}
