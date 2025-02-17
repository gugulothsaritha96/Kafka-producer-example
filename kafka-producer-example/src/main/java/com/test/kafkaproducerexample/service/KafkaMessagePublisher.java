package com.test.kafkaproducerexample.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.test.kafkaproducerexample.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("test-topic-4", "message");
        future.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println("sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }else{
                System.out.println("Unable to send message=[" +
                        message + "] due to: " +ex.getMessage());
            }

        });
    }

    public void sendEventsToTopic(Customer customer) {

        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("test-topic-5", customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("sent message=[" + customer +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            customer + "] due to: " + ex.getMessage());
                }

            });
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
