package msc.edu.learnkafka.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaTest {
    @Value("${spring.kafka.consumer.group-id}")
    private  String topic ;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @GetMapping("/send")
    public ResponseEntity send(@RequestParam String message) {
        kafkaTemplate.send(topic, message);
        System.out.println("Message: "+message+" sent to topic: "+topic);
        return ResponseEntity.ok("Success");
    }
}
