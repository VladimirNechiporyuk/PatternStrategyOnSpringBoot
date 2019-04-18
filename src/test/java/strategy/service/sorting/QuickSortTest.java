package strategy.service.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import strategy.service.SortingDataProcessor;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QuickSortTest {

    @Mock
    SortingDataProcessor sortingDataProcessor;

    private int[] arrayIn = {4, 5, 1, 3, 2};
    private int[] arrayOut = {1, 2, 3, 4, 5};

    @Test
    public void sortTest() {
        when(sortingDataProcessor.process(arrayIn)).thenReturn(arrayOut);
    }
}