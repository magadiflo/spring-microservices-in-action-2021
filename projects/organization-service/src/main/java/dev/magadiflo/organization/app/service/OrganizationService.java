package dev.magadiflo.organization.app.service;

import dev.magadiflo.organization.app.kafka.OrganizationProducer;
import dev.magadiflo.organization.app.model.Organization;
import dev.magadiflo.organization.app.model.enums.ActionEnum;
import dev.magadiflo.organization.app.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final Environment environment;
    private final OrganizationProducer organizationProducer;

    @Transactional(readOnly = true)
    public Organization findById(String organizationId) {
        return this.organizationRepository.findById(organizationId)
                .map(organizationDB -> {
                    Integer port = Integer.parseInt(Objects.requireNonNull(this.environment.getProperty("local.server.port")));
                    organizationDB.setPort(port);

                    this.organizationProducer.publishOrganizationChange(ActionEnum.GET, organizationId);
                    return organizationDB;
                })
                .orElseThrow(() -> new NoSuchElementException("No existe la Organización con el id %s".formatted(organizationId)));
    }

    @Transactional
    public Organization create(Organization organization) {
        organization.setOrganizationId(UUID.randomUUID().toString());
        Organization organizationDB = this.organizationRepository.save(organization);
        this.organizationProducer.publishOrganizationChange(ActionEnum.CREATED, organizationDB.getOrganizationId());
        return organizationDB;
    }

    @Transactional
    public Organization update(Organization organization, String organizationId) {
        return this.organizationRepository.findById(organizationId)
                .map(organizationDB -> {
                    organizationDB.setName(organization.getName());
                    organizationDB.setContactName(organization.getContactName());
                    organizationDB.setContactEmail(organization.getContactEmail());
                    organizationDB.setContactPhone(organization.getContactPhone());
                    return organizationDB;
                })
                .map(organizationDB -> {
                    this.organizationRepository.save(organizationDB);
                    this.organizationProducer.publishOrganizationChange(ActionEnum.UPDATED, organizationId);
                    return organizationDB;
                })
                .orElseThrow(() -> new NoSuchElementException("No hay organizació con id %s para actualizar".formatted(organizationId)));
    }

    @Transactional
    public void delete(String organizationId) {
        this.organizationRepository.deleteById(organizationId);
        this.organizationProducer.publishOrganizationChange(ActionEnum.DELETED, organizationId);
    }
}
