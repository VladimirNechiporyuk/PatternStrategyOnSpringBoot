package strategy.kafkaconsumers;

public interface ArraysConsume {
    void consumeData(int[] array);

    void processingData(int[] initialArray);
}
