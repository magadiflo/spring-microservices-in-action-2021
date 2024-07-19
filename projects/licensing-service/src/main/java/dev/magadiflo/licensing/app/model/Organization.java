package dev.magadiflo.licensing.app.model;

import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("organizations")
public record Organization(@Id
                           String organizationId,
                           String name,
                           String contactName,
                           String contactEmail,
                           String contactPhone,
                           Integer port) {
}