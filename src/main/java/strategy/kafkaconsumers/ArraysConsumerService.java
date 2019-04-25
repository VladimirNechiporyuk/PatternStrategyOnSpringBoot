package strategy.kafkaconsumers;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import strategy.service.DataProcessing;
import strategy.spliters.SpliterFromStringToArray;

@Service
@Slf4j
public class ArraysConsumerService implements ArraysConsume {

    @Autowired
    private DataProcessing processor;

    @Autowired
    private SpliterFromStringToArray spliter;

    @Override
    @KafkaListener(topics = "${kafka.topic.strategy}", groupId = "strategy")
    public void consumeData(ConsumerRecord<String, String> array) {
        log.info("Data {} consumed.", array.value());
        processingData(array.value());
    }

    @Override
    public void processingData(String initialArray) {
        int[] arrayForProcessing = spliter.splitStringToIntArray(initialArray, ",");
        processor.sortAndSaveArrayOfNumbers(arrayForProcessing);
    }
}
