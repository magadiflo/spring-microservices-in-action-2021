package dev.magadiflo.organization.app.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaOrganizationTopicConfig {

    public final static String ORG_CHANGE_TOPIC = "org-change-topic";

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(ORG_CHANGE_TOPIC).build();
    }
}
