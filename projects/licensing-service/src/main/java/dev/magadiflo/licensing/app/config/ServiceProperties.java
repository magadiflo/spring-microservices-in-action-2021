package dev.magadiflo.licensing.app.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "example")
public class ServiceProperties {
    private String property;
}
