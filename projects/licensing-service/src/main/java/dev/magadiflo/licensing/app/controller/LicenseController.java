package dev.magadiflo.licensing.app.controller;

import dev.magadiflo.licensing.app.model.License;
import dev.magadiflo.licensing.app.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * {organizationId} es un marcador de posición que indica cómo espera que se parametrice la URL con un
 * OrganizationId pasado en cada llamada. El uso de OrganizationId en la URL le permite diferenciar
 * entre los diferentes clientes que podrían utilizar su servicio.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/organization/{organizationId}/license")
public class LicenseController {

    private final LicenseService licenseService;

    @GetMapping(path = "/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable String organizationId, @PathVariable String licenseId) {
        License license = this.licenseService.getLicense(licenseId, organizationId);

        license.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class)
                                .getLicense(organizationId, license.getLicenseId()))
                        .withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class)
                                .createLicense(organizationId, license, LocaleContextHolder.getLocale()))
                        .withRel("createLicense"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class)
                                .updateLicense(organizationId, license))
                        .withRel("updateLicense"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LicenseController.class)
                                .deleteLicense(organizationId, license.getLicenseId()))
                        .withRel("deleteLicense"));

        return ResponseEntity.ok(license);
    }

    @PutMapping
    public ResponseEntity<String> updateLicense(@PathVariable String organizationId, @RequestBody License license) {
        return ResponseEntity.ok(this.licenseService.updateLicense(license, organizationId));
    }

    @PostMapping
    public ResponseEntity<String> createLicense(@PathVariable String organizationId,
                                                @RequestBody License license,
                                                @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(this.licenseService.createLicense(license, organizationId, locale));
    }

    @DeleteMapping(path = "/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable String organizationId, @PathVariable String licenseId) {
        return ResponseEntity.ok(this.licenseService.deleteLicense(licenseId, organizationId));
    }

}
