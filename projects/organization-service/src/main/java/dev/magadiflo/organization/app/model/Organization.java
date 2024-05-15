package dev.magadiflo.organization.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    private String organizationId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contactName;

    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String contactPhone;

    @Transient
    private Integer port;
}
