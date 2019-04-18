package strategy.service.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import strategy.StrategyApp;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Profile("inserting")
@ContextConfiguration(classes = StrategyApp.class)
public class InsertingSortTest {

    @Autowired
    private InsertingSort insertingSort;

    private int[] arrayIn = {4, 2, 1, 5, 3};
    private int[] arrayOut = {1, 2, 3, 4, 5};

    @Test
    public void sortTest() {
        assertEquals(Arrays.toString(insertingSort.sort(arrayIn)), Arrays.toString(arrayOut));
    }
}