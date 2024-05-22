package dev.magadiflo.gateway.app.filters;

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

    public TrackingFilter(FilterUtils filterUtils) {
        this.filterUtils = filterUtils;
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
        return chain.filter(exchange);
    }

    private boolean isCorrelationIdPresent(HttpHeaders httpHeaders) {
        return this.filterUtils.getCorrelationId(httpHeaders) != null;
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

}
