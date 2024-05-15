package dev.magadiflo.licensing.app.client;

import dev.magadiflo.licensing.app.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organization-service", path = "/v1/organization")
public interface OrganizationFeignClient {

    @GetMapping(path = "/{organizationId}")
    Organization getOrganization(@PathVariable String organizationId);
}
