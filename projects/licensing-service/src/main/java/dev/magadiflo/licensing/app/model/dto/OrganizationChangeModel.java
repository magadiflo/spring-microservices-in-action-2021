package dev.magadiflo.licensing.app.model.dto;

public record OrganizationChangeModel(String type,
                                      String action,
                                      String organizationId,
                                      String correlationId) {
}