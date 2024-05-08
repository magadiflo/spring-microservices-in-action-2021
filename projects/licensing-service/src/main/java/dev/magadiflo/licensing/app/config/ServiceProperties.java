package dev.magadiflo.licensing.app.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Getter
@Setter
@RefreshScope  // Indica que esta clase debe ser recargada cuando se refresca la configuración
@ConfigurationProperties(prefix = "example")
public class ServiceProperties {
    private String property;
}
