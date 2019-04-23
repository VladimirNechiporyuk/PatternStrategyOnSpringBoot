package strategy.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import strategy.entity.ArrayEntity;
import strategy.repository.ArrayRepository;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProcessingDataService implements DataProcessing {

    private final Logger log = LoggerFactory.getLogger(ProcessingDataService.class);

    @Autowired
    private ArrayRepository repository;

    @Autowired
    private SortingDataSorting dataProcessor;

    @Override
    public Iterable<ArrayEntity> getAllArrays() {
        List<ArrayEntity> allArrays = repository.findAll();
        if (allArrays.isEmpty()) {
            log.error("No arrays found");
            throw new EmptyStackException();
        } else {
            return allArrays;
        }
    }

    @Override
    public ArrayEntity findArrayById(ObjectId id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            log.error("Data with id: {} not found", id);
            throw new NoSuchElementException();
        }
    }

    @Override
    public void sortAndSaveArrayOfNumbers(int[] initialArray) {
        int[] initialData = Arrays.copyOf(initialArray, initialArray.length);
        int[] processedData = dataProcessor.sorting(initialArray);
        ArrayEntity arrayEntity = new ArrayEntity(initialData, processedData);
        ArrayEntity savedEntity = repository.save(arrayEntity);

        log.info("Data with id: {} was saved, initial data: {}, processing data: {}, created date: {}.",
                savedEntity.getId(),
                Arrays.toString(savedEntity.getInitialData()),
                Arrays.toString(savedEntity.getProcessedData()),
                savedEntity.getDateCreated().toString());
    }

    @Override
    public void modifyArray(ObjectId id, int[] newArray) {
        int[] initialData = Arrays.copyOf(newArray, newArray.length);
        int[] processedData = dataProcessor.sorting(newArray);
        ArrayEntity modifiedArray = findArrayById(id);
        modifiedArray.setInitialData(initialData);
        modifiedArray.setProcessedData(processedData);
        repository.save(modifiedArray);

        log.info("Array with id: {} was modified, new initial data: {}, new data {}, modified date {}.",
                modifiedArray.getId(),
                Arrays.toString(modifiedArray.getInitialData()),
                Arrays.toString(modifiedArray.getProcessedData()),
                modifiedArray.getModifiedData().toString());
    }

    @Override
    public void deleteArray(ObjectId id) {
        repository.deleteById(id);
        log.info("Array with id: {} was deleted.", id);
    }
}
