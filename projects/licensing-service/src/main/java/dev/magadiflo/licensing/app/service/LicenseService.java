package dev.magadiflo.licensing.app.service;

import dev.magadiflo.licensing.app.model.License;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class LicenseService {

    private final MessageSource message;

    public License getLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");
        return license;
    }

    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = this.message.getMessage("license.create.message", null, locale)
                    .formatted(license.toString());
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = this.message.getMessage("license.update.message", null, LocaleContextHolder.getLocale())
                    .formatted(license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        return this.message.getMessage("license.delete.message", null, LocaleContextHolder.getLocale())
                .formatted(licenseId, organizationId);
    }

}
