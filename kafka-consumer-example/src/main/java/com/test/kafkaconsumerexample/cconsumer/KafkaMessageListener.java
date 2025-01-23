package com.test.kafkaconsumerexample.cconsumer;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log= LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "test-topic-4" ,groupId="test-group")
    public void consume(String message){
        log.info("consumer consume the message  {}",  message);
    }

    @KafkaListener(topics = "test-topic-4" ,groupId="test-group")
    public void consume1(String message){
        log.info("consumer2 consume the message  {}",  message);
    }

    @KafkaListener(topics = "test-topic-4" ,groupId="test-group")
    public void consume2(String message){
        log.info("consumer3 consume the message  {}",  message);
    }

    @KafkaListener(topics = "test-topic-4" ,groupId="test-group")
    public void consume4(String message){
        log.info("consumer4 consume the message  {}",  message);
    }
}
