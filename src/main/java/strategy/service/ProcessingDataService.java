package strategy.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import strategy.entry.ArrayEntity;
import strategy.repositiry.ArrayRepository;

import java.util.Arrays;

@Service
public class ProcessingDataService {

    private final Log log = LogFactory.getLog(ProcessingDataService.class);

    @Autowired
    private ArrayRepository repository;

    @Autowired
    private SortingDataProcessor dataProcessor;

    public Iterable<ArrayEntity> getAllArrays() {
        return repository.findAll();
    }

    public ArrayEntity findArrayById(ObjectId id) {
        return repository.findByid(id);
    }

    public void sortAndSaveArrayOfNumbers(int[] initialArray) {
        int[] initialData = Arrays.copyOf(initialArray, initialArray.length);
        int[] processedData = dataProcessor.process(initialArray);
        ArrayEntity arrayEntity = new ArrayEntity(initialData, processedData);
        //todo: slf4j, use logger instead of System.out
        log.info(String.format("%s %s %s %s",
                "Data for saving:",
                Arrays.toString(arrayEntity.getInitialData()),
                Arrays.toString(arrayEntity.getProcessedData()),
                arrayEntity.getTimestampCreated().toString()));
        repository.save(arrayEntity);
    }

    public void modifyArray(ObjectId id, int[] newArray) {
        int[] initialData = Arrays.copyOf(newArray, newArray.length);
        int[] processedData = dataProcessor.process(newArray);
        ArrayEntity modifiedArray = findArrayById(id);
        modifiedArray.setInitialData(initialData);
        modifiedArray.setProcessedData(processedData);
        log.info(String.format("%s %s %s %s",
                "Data for modify:",
                Arrays.toString(modifiedArray.getInitialData()),
                Arrays.toString(modifiedArray.getProcessedData()),
                modifiedArray.getTimestampCreated().toString()));
        repository.save(modifiedArray);
    }

    public void deleteArray(ObjectId id) {
//        repository.delete(repository.findById(id));
    }
}
