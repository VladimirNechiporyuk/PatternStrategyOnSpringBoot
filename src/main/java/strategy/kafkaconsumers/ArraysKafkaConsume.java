package strategy.kafkaconsumers;

public interface ArraysKafkaConsume {
    void consumeData(int[] array);

    void processingData(int[] initialArray);
}
