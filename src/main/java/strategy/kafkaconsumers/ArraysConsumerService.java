package strategy.kafkaconsumers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import strategy.service.DataProcessing;

@Service
@Slf4j
public class ArraysConsumerService implements ArraysConsume {

    @Autowired
    private DataProcessing processor;

    @Override
    @KafkaListener(topics = "${randomArrayTOPIC}", groupId = "strategy")
    public void consumeData(int[] array) {
        log.info("Array {} consumed.", array);
        processingData(array);
    }

    @Override
    public void processingData(int[] initialArray) {
        processor.sortAndSaveArrayOfNumbers(initialArray);
    }
}
