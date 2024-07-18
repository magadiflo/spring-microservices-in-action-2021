package dev.magadiflo.licensing.app.model.dto;

public record OrganizationChange(String action,
                                 String organizationId,
                                 String correlationId) {
}