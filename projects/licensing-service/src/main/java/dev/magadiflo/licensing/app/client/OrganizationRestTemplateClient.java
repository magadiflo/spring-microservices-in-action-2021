package dev.magadiflo.licensing.app.client;

import dev.magadiflo.licensing.app.model.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class OrganizationRestTemplateClient {

    private final RestTemplate restTemplate;

    public Organization getOrganization(String organizationId) {
        ResponseEntity<Organization> exchange = this.restTemplate.exchange(
                "http://organization-service/v1/organization/{id}",
                HttpMethod.GET,
                null,
                Organization.class,
                Collections.singletonMap("id", organizationId));
        return exchange.getBody();
    }
}
