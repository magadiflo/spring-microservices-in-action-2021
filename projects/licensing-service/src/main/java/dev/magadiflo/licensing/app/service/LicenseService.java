package dev.magadiflo.licensing.app.service;

import dev.magadiflo.licensing.app.config.ServiceProperties;
import dev.magadiflo.licensing.app.model.License;
import dev.magadiflo.licensing.app.repository.LicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LicenseService {

    private final MessageSource message;
    private final LicenseRepository licenseRepository;
    private final ServiceProperties serviceProperties;

    public License getLicense(String licenseId, String organizationId) {
        return this.licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId)
                .map(licenseDB -> licenseDB.withComments(this.serviceProperties.getProperty()))
                .orElseThrow(() -> new IllegalArgumentException(
                                this.message.getMessage("license.search.error.message", null, LocaleContextHolder.getLocale())
                                        .formatted(licenseId, organizationId)
                        )
                );
    }

    public License createLicense(License license) {
        license.setLicenseId(UUID.randomUUID().toString());
        License licenseDB = this.licenseRepository.save(license);
        return licenseDB.withComments(this.serviceProperties.getProperty());
    }

    public License updateLicense(String licenseId, License license) {
        return this.licenseRepository.findById(licenseId)
                .map(licenseDB -> {
                    licenseDB.setDescription(license.getDescription());
                    licenseDB.setLicenseType(license.getLicenseType());
                    licenseDB.setProductName(license.getProductName());
                    licenseDB.setOrganizationId(license.getOrganizationId());
                    return licenseDB;
                })
                .map(this.licenseRepository::save)
                .map(licenseDB -> licenseDB.withComments(this.serviceProperties.getProperty()))
                .orElseThrow(() -> new NoSuchElementException(
                                this.message.getMessage("license.search.error.update.message", null, LocaleContextHolder.getLocale())
                                        .formatted(licenseId)
                        )
                );
    }

    public String deleteLicense(String licenseId) {
        this.licenseRepository.deleteById(licenseId);
        return this.message.getMessage("license.delete.message", null, LocaleContextHolder.getLocale())
                .formatted(licenseId);
    }

}
