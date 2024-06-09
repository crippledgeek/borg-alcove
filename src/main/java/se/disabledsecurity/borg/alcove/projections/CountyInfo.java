package se.disabledsecurity.borg.alcove.projections;

import java.util.Set;

/**
 * Projection for {@link se.disabledsecurity.borg.alcove.entity.County}
 */
public interface CountyInfo {
    String getName();

    int getCode();

    Set<MunicipalityInfo> getMunicipalities();
}