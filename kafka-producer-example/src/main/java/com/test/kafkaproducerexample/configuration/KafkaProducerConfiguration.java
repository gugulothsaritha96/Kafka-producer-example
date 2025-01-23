package com.test.kafkaproducerexample.configuration;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class KafkaProducerConfiguration {

    @Bean
    public NewTopic createTopic() {
        return new NewTopic("test-topic-3 ", 3, (short) 1);
    }
}
