package strategy.kafkaconsumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ArraysConsume {
    void consumeData(ConsumerRecord<String, String> array);

    void processingData(String initialArray);
}
