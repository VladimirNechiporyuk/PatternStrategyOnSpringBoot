package strategy.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import strategy.entity.ArrayEntity;
import strategy.repository.ArrayRepository;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Service
public class ProcessingDataService implements DataProcessing{

    private final Log log = LogFactory.getLog(ProcessingDataService.class);

    @Autowired
    private ArrayRepository repository;

    @Autowired
    private SortingDataSorting dataProcessor;

    @Override
    public Iterable<ArrayEntity> getAllArrays() {
        return repository.findAll();
    }

    @Override
    public ArrayEntity findArrayById(ObjectId id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            log.info("Data with id: " + id.toString() + " doesn't exist");
            throw new NoSuchElementException();
        }
    }

    @Override
    public void sortAndSaveArrayOfNumbers(int[] initialArray) {
        int[] initialData = Arrays.copyOf(initialArray, initialArray.length);
        int[] processedData = dataProcessor.sorting(initialArray);
        ArrayEntity arrayEntity = new ArrayEntity(initialData, processedData);
        ArrayEntity savedEntity = repository.save(arrayEntity);

        log.info(String.format("Data with %s saved:  %s Data saved %s %s",
                savedEntity.getId(),
                Arrays.toString(savedEntity.getInitialData()),
                Arrays.toString(savedEntity.getProcessedData()),
                savedEntity.getTimestampCreated().toString()));
    }

    @Override
    public void modifyArray(ObjectId id, int[] newArray) {
        int[] initialData = Arrays.copyOf(newArray, newArray.length);
        int[] processedData = dataProcessor.sorting(newArray);
        ArrayEntity modifiedArray = findArrayById(id);
        modifiedArray.setInitialData(initialData);
        modifiedArray.setProcessedData(processedData);
        repository.save(modifiedArray);

        log.info(String.format("Array with id: %s, data for modify: %s, Data modified %s %s",
                modifiedArray.getId(),
                Arrays.toString(modifiedArray.getInitialData()),
                Arrays.toString(modifiedArray.getProcessedData()),
                modifiedArray.getModifiedData().toString()));
    }

    @Override
    public void deleteArray(ObjectId id) {
        repository.deleteById(id);
    }
}
