package se.disabledsecurity.borg.alcove.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import se.disabledsecurity.borg.alcove.entity.County;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = DatabaseMunicipalityMapper.class)
public interface DatabaseCountyMapper {
	@InheritInverseConfiguration(name = "toDto")
	County toEntity(se.disabledsecurity.borg.alcove.model.internal.County county);

	List<County> toEntities(List<se.disabledsecurity.borg.alcove.model.internal.County> counties);

	@InheritInverseConfiguration(name = "toEntities")
	List<se.disabledsecurity.borg.alcove.model.internal.County> toDtos(List<County> counties);
	se.disabledsecurity.borg.alcove.model.internal.County toDto(County county);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	County partialUpdate(se.disabledsecurity.borg.alcove.model.internal.County source, @MappingTarget County county);
}