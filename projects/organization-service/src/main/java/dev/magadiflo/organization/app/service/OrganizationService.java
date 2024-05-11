package dev.magadiflo.organization.app.service;

import dev.magadiflo.organization.app.model.Organization;
import dev.magadiflo.organization.app.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Transactional(readOnly = true)
    public Organization findById(String organizationId) {
        return this.organizationRepository.findById(organizationId)
                .orElseThrow(() -> new NoSuchElementException("No existe la Organización con el id %s".formatted(organizationId)));
    }

    @Transactional
    public Organization create(Organization organization) {
        organization.setOrganizationId(UUID.randomUUID().toString());
        return this.organizationRepository.save(organization);
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
                .map(this.organizationRepository::save)
                .orElseThrow(() -> new NoSuchElementException("No hay organizació con id %s para actualizar".formatted(organizationId)));
    }

    @Transactional
    public void delete(String organizationId) {
        this.organizationRepository.deleteById(organizationId);
    }
}
