package dev.magadiflo.licensing.app.client;

import dev.magadiflo.licensing.app.model.Organization;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OrganizationRestClient {

    private final RestClient restClient;

    public OrganizationRestClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://organization-service/v1/organization").build();
    }

    public Organization getOrganization(String organizationId) {
        return this.restClient.get()
                .uri("/{id}", organizationId)
                .retrieve()
                .body(Organization.class);
    }
}
