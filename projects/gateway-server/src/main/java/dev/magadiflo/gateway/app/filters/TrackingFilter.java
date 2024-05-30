package dev.magadiflo.gateway.app.filters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Order(1)
@Component
public class TrackingFilter implements GlobalFilter {

    private static final Logger log = LoggerFactory.getLogger(TrackingFilter.class);
    private final FilterUtils filterUtils;
    private final ObjectMapper objectMapper;

    public TrackingFilter(FilterUtils filterUtils, ObjectMapper objectMapper) {
        this.filterUtils = filterUtils;
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();

        if (this.isCorrelationIdPresent(headers)) {
            log.debug("Se encontrón tmx-correlation-id en tracking filter: {}", this.filterUtils.getCorrelationId(headers));
        } else {
            String correlationId = this.generateCorrelationId();
            exchange = this.filterUtils.setCorrelationId(exchange, correlationId);
            log.debug("tmx-correlation-id generado en el tracking filter: {}", correlationId);
        }
        log.info("El nombre de la autenticación del token es: {}", this.getUsername(headers));
        return chain.filter(exchange);
    }

    private boolean isCorrelationIdPresent(HttpHeaders httpHeaders) {
        return this.filterUtils.getCorrelationId(httpHeaders) != null;
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

    private String getUsername(HttpHeaders httpHeaders) {
        String username = "";

        if (this.filterUtils.getAuthToken(httpHeaders) != null) {
            String jwt = this.filterUtils.getAuthToken(httpHeaders)
                    .replace("Bearer ", "");
            String json = this.payload(jwt);
            try {
                JsonNode jsonNode = this.objectMapper.readTree(json);
                username = jsonNode.get("preferred_username").asText();
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Error al ejecutar el método readTree del ObjectMapper: " + e);
            }
        }

        return username;
    }

    private String payload(String jwt) {
        String[] jwtParts = jwt.split("\\.");
        String base64EncodedPayload = jwtParts[1];
        Base64 base64 = new Base64(true);
        return new String(base64.decode(base64EncodedPayload));
    }
}
