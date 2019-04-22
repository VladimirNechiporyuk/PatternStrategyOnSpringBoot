package strategy.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    public void sortAndSaveArrayOfNumbers(int[] initialArray) {
        int[] initialData = Arrays.copyOf(initialArray, initialArray.length);
        int[] processedData = dataProcessor.process(initialArray);
        ArrayEntity arrayEntity = new ArrayEntity(initialData, processedData);
        //todo: slf4j, use logger instead of System.out
        log.info(String.format("%s %s %s",
                Arrays.toString(arrayEntity.getInitialData()),
                Arrays.toString(arrayEntity.getProcessedData()),
                arrayEntity.getTimestampCreated().toString()));
        repository.save(arrayEntity);
    }

//    public void deleteArray(int[] arrayForDelete) {
//
//        repository.delete();
//    }
}
