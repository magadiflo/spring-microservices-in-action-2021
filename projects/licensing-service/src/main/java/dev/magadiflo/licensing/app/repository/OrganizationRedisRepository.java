package dev.magadiflo.licensing.app.repository;

import dev.magadiflo.licensing.app.model.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRedisRepository extends CrudRepository<Organization, String> {
}
