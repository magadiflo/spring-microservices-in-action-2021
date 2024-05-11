package dev.magadiflo.organization.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * `Spring Boot Actuator` ofrece una anotación `@RefreshScope`
 * Indica que esta clase debe ser recargada cuando se refresca la configuración
 */
@RefreshScope
@SpringBootApplication
public class OrganizationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationServiceApplication.class, args);
    }

}
