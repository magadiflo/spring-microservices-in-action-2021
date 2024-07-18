package dev.magadiflo.organization.app.kafka;

import dev.magadiflo.organization.app.config.KafkaOrganizationTopicConfig;
import dev.magadiflo.organization.app.model.dto.OrganizationChangeModel;
import dev.magadiflo.organization.app.model.enums.ActionEnum;
import dev.magadiflo.organization.app.utils.UserContextHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrganizationProducer {

    private final KafkaTemplate<String, OrganizationChangeModel> kafkaTemplate;

    public void publishOrganizationChange(ActionEnum action, String organizationId) {
        log.debug("Enviando mensaje a Kafka {} para el organizationId {}", action, organizationId);

        OrganizationChangeModel organizationChangeModel = new OrganizationChangeModel(
                action.name(),
                organizationId,
                UserContextHolder.getContext().getCorrelationId());

        Message<OrganizationChangeModel> message = MessageBuilder
                .withPayload(organizationChangeModel)
                .setHeader(KafkaHeaders.TOPIC, KafkaOrganizationTopicConfig.ORG_CHANGE_TOPIC)
                .build();

        this.kafkaTemplate.send(message);
    }

}
