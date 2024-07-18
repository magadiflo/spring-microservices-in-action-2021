package dev.magadiflo.gateway.app.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

@Configuration
public class ResponseFilter {

    private final static Logger log = LoggerFactory.getLogger(ResponseFilter.class);

    private final FilterUtils filterUtils;

    public ResponseFilter(FilterUtils filterUtils) {
        this.filterUtils = filterUtils;
    }

    @Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    HttpHeaders headers = exchange.getRequest().getHeaders();
                    String correlationId = this.filterUtils.getCorrelationId(headers);

                    log.debug("Agregando ID de correlación a los headers de respuesta: {}", correlationId);

                    exchange.getResponse()
                            .getHeaders()
                            .add(FilterUtils.CORRELATION_ID, correlationId);

                    log.debug("Completando solicitud saliente para: {}", exchange.getRequest().getURI());
                }));
    }
}
