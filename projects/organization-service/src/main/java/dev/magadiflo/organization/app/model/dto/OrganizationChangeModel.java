package dev.magadiflo.organization.app.model.dto;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrganizationChangeModel {
    private String type;
    private String action;
    private String organizationId;
    private String correlationId;
}
