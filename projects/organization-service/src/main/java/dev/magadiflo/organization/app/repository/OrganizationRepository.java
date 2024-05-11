package dev.magadiflo.organization.app.repository;

import dev.magadiflo.organization.app.model.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization, String> {

}
