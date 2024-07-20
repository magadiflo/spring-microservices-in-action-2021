package dev.magadiflo.licensing.app.model;

public record Organization(String organizationId,
                           String name,
                           String contactName,
                           String contactEmail,
                           String contactPhone,
                           Integer port) {
}