package strategy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import strategy.entity.ArrayEntity;
import strategy.kafkaproducers.ArraysProduce;

@RestController
@RequestMapping(path = "/randomArray")
public class ArraysKafkaController {

    @Autowired
    private ArraysProduce producer;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ArrayEntity> generateArrayAndSendToKafka() {
        producer.generateDataAndSendToKafka();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
