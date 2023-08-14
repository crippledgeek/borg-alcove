package se.disabledsecurity.borg.alcove.model.external;

import lombok.Builder;

@Builder
public record Location(String county, String municipality, String code) {
}