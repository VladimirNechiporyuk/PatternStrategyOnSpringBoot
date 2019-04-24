package strategy.kafkaproducers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import strategy.data.RandomDataGenerator;

import java.util.Arrays;

@Service
@Slf4j
public class ArraysProducerService implements ArraysProduce {

    @Value("${kafka.topic.strategy}")
    private String kafkaTOPIC;

    @Value("${array.length:10}")
    private int arrayLength;

    @Value("${array.bound:2}")
    private int numBound;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private RandomDataGenerator dataGenerator;

    @Override
    public void generateDataAndSendToKafka() {
        String randomArray = Arrays.toString(dataGenerator.generateData(arrayLength, numBound));
        log.info("Data {} generated.", randomArray);
        kafkaTemplate.send(kafkaTOPIC, randomArray);
        log.info("Data {} sent.", randomArray);
    }
}
