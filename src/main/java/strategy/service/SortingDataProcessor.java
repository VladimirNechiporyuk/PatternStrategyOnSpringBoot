package strategy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import strategy.service.sorting.SortingStrategy;

@Component
public class SortingDataProcessor implements DataProcessor {

    @Autowired
    private SortingStrategy strategy;

    @Override
    public int[] process(int[] array) {
        return strategy.sort(array);
    }
}
