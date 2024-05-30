package dev.magadiflo.licensing.app.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;

import java.io.IOException;

@Slf4j
public class PropagationInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getCredentials() instanceof AbstractOAuth2Token token)) {
            return execution.execute(request, body);
        }

        log.info("Propagando access_token: {}", token.getTokenValue());
        request.getHeaders().setBearerAuth(token.getTokenValue());
        return execution.execute(request, body);
    }
}
