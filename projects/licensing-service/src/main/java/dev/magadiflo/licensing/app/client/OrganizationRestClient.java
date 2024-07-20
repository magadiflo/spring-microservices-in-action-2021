package dev.magadiflo.licensing.app.client;

import dev.magadiflo.licensing.app.model.Organization;
import dev.magadiflo.licensing.app.model.OrganizationModelRedis;
import dev.magadiflo.licensing.app.repository.OrganizationRedisRepository;
import dev.magadiflo.licensing.app.utils.UserContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class OrganizationRestClient {

    private final RestClient restClient;
    private final OrganizationRedisRepository organizationRedisRepository;

    public OrganizationRestClient(RestClient.Builder restClientBuilder,
                                  OrganizationRedisRepository organizationRedisRepository) {
        this.restClient = restClientBuilder.baseUrl("http://organization-service/v1/organization").build();
        this.organizationRedisRepository = organizationRedisRepository;
    }

    public Organization getOrganization(String organizationId) {
        log.debug("En licensing Service.getOrganization con el id de correlación: {}",
                UserContextHolder.getContext().getCorrelationId());

        OrganizationModelRedis organizationModelRedis = this.checkRedisCache(organizationId);
        if (organizationModelRedis != null) {
            log.debug("Se ha recuperado con éxito una organización {} del caché de Redis: {}", organizationId, organizationModelRedis);

            return new Organization(
                    organizationModelRedis.getId(),
                    organizationModelRedis.getName(),
                    organizationModelRedis.getContactName(),
                    organizationModelRedis.getContactEmail(),
                    organizationModelRedis.getContactPhone(),
                    organizationModelRedis.getPort()
            );
        }

        log.debug("No se pudo localizar la organización desde la caché de Redis: {}", organizationId);

        Organization organization = this.restClient.get()
                .uri("/{id}", organizationId)
                .retrieve()
                .body(Organization.class);

        if (organization != null) {
            this.cacheOrganizationObject(OrganizationModelRedis.builder()
                    .id(organization.organizationId())
                    .name(organization.name())
                    .contactName(organization.contactName())
                    .contactEmail(organization.contactEmail())
                    .contactPhone(organization.contactPhone())
                    .port(organization.port())
                    .build());
        }
        return organization;
    }

    private OrganizationModelRedis checkRedisCache(String organizationId) {
        try {
            return this.organizationRedisRepository.findById(organizationId).orElseGet(() -> null);
        } catch (Exception e) {
            log.error("Error al intentar recuperar la organización {}, verifique Redis Cache. Excepción {}",
                    organizationId, e.getMessage());
            return null;
        }
    }

    private void cacheOrganizationObject(OrganizationModelRedis organizationModelRedis) {
        try {
            this.organizationRedisRepository.save(organizationModelRedis);
        } catch (Exception e) {
            log.error("No se puede almacenar en caché de Redis la organización {}. Excepción {}",
                    organizationModelRedis.getId(), e.getMessage());
        }
    }
}
