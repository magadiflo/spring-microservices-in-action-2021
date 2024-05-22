package dev.magadiflo.licensing.app.config;

import dev.magadiflo.licensing.app.utils.UserContextInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class AppConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(new UserContextInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    @LoadBalanced
    @Bean
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder()
                .requestInterceptors(clientHttpRequestInterceptors ->
                        clientHttpRequestInterceptors.add(new UserContextInterceptor()));
    }

}
