package dev.magadiflo.licensing.app.controller;

import dev.magadiflo.licensing.app.model.License;
import dev.magadiflo.licensing.app.service.LicenseService;
import dev.magadiflo.licensing.app.utils.UserContextHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * {organizationId} es un marcador de posición que indica cómo espera que se parametrice la URL con un
 * OrganizationId pasado en cada llamada. El uso de OrganizationId en la URL le permite diferenciar
 * entre los diferentes clientes que podrían utilizar su servicio.
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/organization/{organizationId}/license")
public class LicenseController {

    private final LicenseService licenseService;

    // El parámetro action puede tomar los siguientes valores: success (default), exception, sleep y random
    @GetMapping
    public ResponseEntity<List<License>> getLicenses(@PathVariable String organizationId,
                                                     @RequestParam(defaultValue = "success") String action) throws TimeoutException {
        log.info("LicenseServiceController Correlation ID: {}", UserContextHolder.getContext().getCorrelationId());
        return ResponseEntity.ok(this.licenseService.getLicensesByOrganization(organizationId, action));
    }

    @GetMapping(path = "/{licenseId}/{httpClientType}")
    public ResponseEntity<License> getLicensesWithClient(@PathVariable String organizationId,
                                                         @PathVariable String licenseId,
                                                         @PathVariable String httpClientType) {
        return ResponseEntity.ok(this.licenseService.getLicense(organizationId, licenseId, httpClientType));
    }

    @GetMapping(path = "/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable String organizationId, @PathVariable String licenseId) {
        License license = this.licenseService.getLicense(licenseId, organizationId);

        license.add(
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class).getLicense(organizationId, license.getLicenseId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class).createLicense(license)).withRel("createLicense"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class).updateLicense(organizationId, license)).withRel("updateLicense"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class).deleteLicense(organizationId)).withRel("deleteLicense")
        );

        return ResponseEntity.ok(license);
    }

    @PutMapping(path = "/{licenseId}")
    public ResponseEntity<License> updateLicense(@PathVariable String licenseId, @RequestBody License license) {
        return ResponseEntity.ok(this.licenseService.updateLicense(licenseId, license));
    }

    @PostMapping
    public ResponseEntity<License> createLicense(@RequestBody License license) {
        return ResponseEntity.ok(this.licenseService.createLicense(license));
    }

    @DeleteMapping(path = "/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable String licenseId) {
        return ResponseEntity.ok(this.licenseService.deleteLicense(licenseId));
    }

}
