package strategy.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import strategy.entry.ArrayEntity;
import strategy.entry.ArrayEntityFactory;
import strategy.outers.OutputInConsole;
import strategy.repositiry.ArrayRepository;
import strategy.service.SortingDataProcessor;

import java.util.Date;

@Component
public class Sorter implements ApplicationRunner {

    @Autowired
    private OutputInConsole outputNumbers;

    @Autowired
    private SortingDataProcessor dataProcessor;

    @Autowired
    private ArrayRepository repository;

    @Autowired
    private ArrayEntityFactory arrayEntityFactory;

    @Override
    public void run(ApplicationArguments args) {
        ArrayEntity entity = arrayEntityFactory.getArrayEntity();
        entity.setOutputtedArray(dataProcessor.process(entity.getOutputtedArray()));
        entity.setTimestampModified(new Date());
        repository.save(entity);
    }
}
