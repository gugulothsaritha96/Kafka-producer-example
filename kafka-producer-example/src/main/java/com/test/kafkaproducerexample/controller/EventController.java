package com.test.kafkaproducerexample.controller;


import com.test.kafkaproducerexample.dto.Customer;
import com.test.kafkaproducerexample.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){

        for( int i=0; i<=10000; i++ ){
            publisher.sendMessageToTopic(message + " : "+i );
        }

        try {
            return ResponseEntity.ok("message published successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/publish")
    public void sendEvents(@RequestBody Customer customer){
        publisher.sendEventsToTopic(customer);

    }
}
