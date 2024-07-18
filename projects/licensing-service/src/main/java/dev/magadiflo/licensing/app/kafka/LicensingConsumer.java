package dev.magadiflo.licensing.app.kafka;

import dev.magadiflo.licensing.app.model.dto.OrganizationChange;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class LicensingConsumer {

    @KafkaListener(topics = "org-change-topic", groupId = "licensing-group")
    public void consumeOrganizationChange(OrganizationChange organizationChange) {
        log.debug("Se recibió un {} evento para el ID de la organización {} con id de correlación {}",
                organizationChange.action(), organizationChange.organizationId(), organizationChange.correlationId());
    }

}
