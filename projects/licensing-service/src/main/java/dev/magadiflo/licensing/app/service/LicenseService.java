package dev.magadiflo.licensing.app.service;

import dev.magadiflo.licensing.app.client.OrganizationDiscoveryClient;
import dev.magadiflo.licensing.app.client.OrganizationFeignClient;
import dev.magadiflo.licensing.app.client.OrganizationRestClient;
import dev.magadiflo.licensing.app.client.OrganizationRestTemplateClient;
import dev.magadiflo.licensing.app.config.ServiceProperties;
import dev.magadiflo.licensing.app.model.License;
import dev.magadiflo.licensing.app.model.Organization;
import dev.magadiflo.licensing.app.repository.LicenseRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
@RequiredArgsConstructor
@Service
public class LicenseService {

    private final MessageSource message;
    private final LicenseRepository licenseRepository;
    private final ServiceProperties serviceProperties;

    private final OrganizationFeignClient organizationFeignClient;
    private final OrganizationRestTemplateClient organizationRestTemplateClient;
    private final OrganizationDiscoveryClient organizationDiscoveryClient;
    private final OrganizationRestClient organizationRestClient;

    @CircuitBreaker(name = "licenseService")
    public List<License> getLicensesByOrganization(String organizationId, String action) {
        switch (action) {
            case "exception" -> this.timeoutException();
            case "sleep" -> this.sleep();
            case "random" -> this.randomlyRunLong();
        }
        return this.licenseRepository.findByOrganizationId(organizationId);
    }

    public License getLicense(String organizationId, String licenseId, String httpClientType) {
        return this.licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId)
                .map(licenseDB -> {
                    Organization organization = this.retrieveOrganizationInfo(organizationId, httpClientType);
                    if (organization != null) {
                        licenseDB.setOrganizationName(organization.name());
                        licenseDB.setContactName(organization.contactName());
                        licenseDB.setContactEmail(organization.contactEmail());
                        licenseDB.setContactPhone(organization.contactPhone());
                        licenseDB.setPort(organization.port());
                    }
                    return licenseDB.withComments(this.serviceProperties.getProperty());
                })
                .orElseThrow(() -> new IllegalArgumentException(
                        this.message.getMessage("license.search.error.message", null, LocaleContextHolder.getLocale())
                                .formatted(licenseId, organizationId))
                );
    }

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

    private Organization retrieveOrganizationInfo(String organizationId, String httpClientType) {
        log.info("Estoy usando {} como cliente HTTP", httpClientType);
        return switch (httpClientType) {
            case "feign" -> this.organizationFeignClient.getOrganization(organizationId);
            case "restTemplate" -> this.getOrganization(organizationId);
            case "discovery" -> this.organizationDiscoveryClient.getOrganization(organizationId);
            case "restClient" -> this.organizationRestClient.getOrganization(organizationId);
            default -> null;
        };
    }

    @CircuitBreaker(name = "organizationService")
    private Organization getOrganization(String organizationId) {
        return this.organizationRestTemplateClient.getOrganization(organizationId);
    }

    // Nos da una posibilidad entre tres de que una llamada a la base de datos dure mucho tiempo
    private void randomlyRunLong() {
        Random random = new Random();
        int randomNum = random.nextInt(3) + 1;
        if (randomNum == 3) this.sleep();
    }

    // Duerme durante 5000ms (5s)
    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Lanza un error
    private void timeoutException() {
        try {
            throw new TimeoutException();
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
