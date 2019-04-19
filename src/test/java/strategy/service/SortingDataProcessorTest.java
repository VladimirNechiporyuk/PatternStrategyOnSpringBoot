package strategy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import strategy.StrategyApp;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = StrategyApp.class)
public class SortingDataProcessorTest {

    @Autowired
    private SortingDataProcessor sortingDataProcessor;

    private int[] arrayIn = {4, 5, 1, 3, 2};
    private int[] arrayOut = {1, 2, 3, 4, 5};

    @Test
    public void processTest() {
        when(sortingDataProcessor.process(arrayIn)).thenReturn(arrayOut);
    }
}