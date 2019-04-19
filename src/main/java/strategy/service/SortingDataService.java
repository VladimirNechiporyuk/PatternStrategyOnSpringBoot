package strategy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import strategy.entry.ArrayEntity;
import strategy.repositiry.ArrayRepository;

import java.util.Arrays;

@Service
public class SortingDataService {

    @Autowired
    private ArrayRepository repository;

    @Autowired
    private SortingDataProcessor dataProcessor;

    public Iterable<ArrayEntity> getAllArrays() {
        return repository.findAll();
    }

    public ArrayEntity sortAndSaveArrayOfNumbers(int[] initialArray) {
        int[] initialData = Arrays.copyOf(initialArray, initialArray.length);
        int[] processedData = dataProcessor.process(initialArray);
        ArrayEntity arrayEntity = new ArrayEntity(initialData, processedData);
        System.out.println(">>>>>>>>>>>>>> Array was created");
        return repository.save(arrayEntity);
    }
}
