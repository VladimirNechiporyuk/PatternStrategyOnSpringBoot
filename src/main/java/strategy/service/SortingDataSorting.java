package strategy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import strategy.service.sorting.SortingStrategy;

@Component
public class SortingDataSorting implements DataSorting {

    @Autowired
    private SortingStrategy strategy;

    @Override
    public int[] sorting(int[] array) {
        return strategy.sort(array);
    }
}
