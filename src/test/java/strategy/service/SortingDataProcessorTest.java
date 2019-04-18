package strategy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SortingDataProcessorTest {

    @Mock
    SortingDataProcessor sortingDataProcessor;

    private int[] arrayIn = {4, 5, 1, 3, 2};
    private int[] arrayOut = {1, 2, 3, 4, 5};

    @Test
    public void processTest() {
        when(sortingDataProcessor.process(arrayIn)).thenReturn(arrayOut);
    }
}