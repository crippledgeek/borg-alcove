package se.disabledsecurity.borg.alcove.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import se.disabledsecurity.borg.alcove.entity.Municipality;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DatabaseMunicipalityMapper {
	Municipality toEntity(se.disabledsecurity.borg.alcove.model.internal.Municipality municipality);

	se.disabledsecurity.borg.alcove.model.internal.Municipality toDto(Municipality municipality);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	Municipality partialUpdate(se.disabledsecurity.borg.alcove.model.internal.Municipality source, @MappingTarget Municipality municipality);
}