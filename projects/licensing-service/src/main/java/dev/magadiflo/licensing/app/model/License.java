package dev.magadiflo.licensing.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

/**
 * Recordar que el RepresentationModel<License> corresponde
 * a la implementación del hateoas en el proyecto.
 */
@ToString
@Getter
@Setter
@Entity
@Table(name = "licenses")
public class License extends RepresentationModel<License> {
    @Id
    private String licenseId;

    private String description;

    @Column(nullable = false)
    private String organizationId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String licenseType;

    private String comment;

    @Transient
    private String organizationName;
    @Transient
    private String contactName;
    @Transient
    private String contactPhone;
    @Transient
    private String contactEmail;
    @Transient
    private Integer port;

    public License withComments(String comment) {
        this.setComment(comment);
        return this;
    }
}
