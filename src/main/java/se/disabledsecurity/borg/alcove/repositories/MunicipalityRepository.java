package se.disabledsecurity.borg.alcove.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import se.disabledsecurity.borg.alcove.entity.County;
import se.disabledsecurity.borg.alcove.entity.Municipality;

import java.util.List;
import java.util.UUID;

public interface MunicipalityRepository extends ListCrudRepository<Municipality, UUID> {

}