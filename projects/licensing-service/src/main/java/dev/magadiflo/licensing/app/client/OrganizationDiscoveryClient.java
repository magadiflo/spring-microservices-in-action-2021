package dev.magadiflo.licensing.app.client;

import dev.magadiflo.licensing.app.model.Organization;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrganizationDiscoveryClient {

    private final DiscoveryClient discoveryClient;

    public Organization getOrganization(String organizationId) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = this.discoveryClient.getInstances("organization-service");
        log.info("Instancias recuperadas del organization-service: {}", instances);

        if (instances.isEmpty()) {
            log.warn("No se encontraron instancias del servicio organization-service");
            return null;
        }

        String serviceUri = "%s/v1/organization/{id}".formatted(instances.getFirst().getUri().toString());
        ResponseEntity<Organization> exchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, Organization.class, Collections.singletonMap("id", organizationId));
        return exchange.getBody();
    }
}
