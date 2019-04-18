package strategy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import strategy.data.RandomDataGenerator;
import strategy.outers.OutputInConsole;

@Component
public class Sorter implements ApplicationRunner {

    @Value("${array.length:10}")
    private int arrayLength;

    @Value("${array.bound:2}")
    private int numBound;

    @Autowired
    private RandomDataGenerator dataGenerator;

    @Autowired
    private OutputInConsole outputNumbers;

    @Autowired
    private SortingDataProcessor dataProcessor;

    @Override
    public void run(ApplicationArguments args) {
        int[] data = dataGenerator.generateData(arrayLength, numBound);
        outputNumbers.outNumbersArray("Array before sorting:", data);
        outputNumbers.outNumbersArray("\nArray after sorting:", dataProcessor.process(data));
    }
}
