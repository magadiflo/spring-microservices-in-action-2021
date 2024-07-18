package dev.magadiflo.organization.app.model.dto;

public record OrganizationChangeModel(String action,
                                      String organizationId,
                                      String correlationId) {
}
