package dev.magadiflo.organization.app.controller;

import dev.magadiflo.organization.app.model.Organization;
import dev.magadiflo.organization.app.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping(path = "/{organizationId}")
    public ResponseEntity<Organization> getOrganization(@PathVariable String organizationId) {
        return ResponseEntity.ok(this.organizationService.findById(organizationId));
    }

    @PostMapping
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization) {
        Organization organizationDB = this.organizationService.create(organization);
        URI location = URI.create("/v1/organization/" + organizationDB.getOrganizationId());
        return ResponseEntity.created(location).body(organizationDB);
    }

    @PutMapping(path = "/{organizationId}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable String organizationId, @RequestBody Organization organization) {
        return ResponseEntity.ok(this.organizationService.update(organization, organizationId));
    }

    @DeleteMapping(path = "/{organizationId}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable String organizationId) {
        this.organizationService.delete(organizationId);
        return ResponseEntity.noContent().build();
    }

}
