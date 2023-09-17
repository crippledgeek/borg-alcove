package se.disabledsecurity.borg.alcove.model.internal;

import lombok.Builder;

import java.util.Set;

@Builder
public record County(String name, int code, Set<Municipality> municipalities) {
}
