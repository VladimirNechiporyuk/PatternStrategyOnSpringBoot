package strategy.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import strategy.data.RandomDataGenerator;
import strategy.entry.ArrayEntity;
import strategy.outers.OutputInConsole;
import strategy.repositiry.ArrayRepository;
import strategy.service.SortingDataProcessor;

import java.util.Arrays;

@Service
public class Runner implements ApplicationRunner {

    @Value("${array.length:10}")
    private int arrayLength;

    @Value("${array.bound:2}")
    private int numBound;

    @Autowired
    private OutputInConsole outputNumbers;

    @Autowired
    private SortingDataProcessor dataProcessor;

    @Autowired
    private ArrayRepository repository;

    @Autowired
    private RandomDataGenerator dataGenerator;

    @Override
    public void run(ApplicationArguments args) {
        int[] generatedData = dataGenerator.generateData(arrayLength, numBound);
        int[] initialData = Arrays.copyOf(generatedData, generatedData.length);
        int[] processedData = dataProcessor.process(generatedData);
        ArrayEntity entity = new ArrayEntity(initialData, processedData);
        repository.save(entity);
    }
}
