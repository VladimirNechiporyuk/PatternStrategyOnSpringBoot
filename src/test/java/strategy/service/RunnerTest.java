package strategy.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import strategy.StrategyApp;
import strategy.data.RandomDataGenerator;
import strategy.starter.Runner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = StrategyApp.class)
public class RunnerTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Value("${array.length:10}")
    private int arrayLength;

    @Value("${array.bound:2}")
    private int numBound;

    @Autowired
    private Runner runner;

    @Autowired
    private SortingDataProcessor dataProcessor;

    @MockBean
    private RandomDataGenerator dataGenerator;

    @Test
    public void runTest() {
        int[] array = {5, 2, 3, 1, 4, 6};
        when(dataGenerator.generateData(arrayLength, numBound)).thenReturn(array);

        runner.run(new DefaultApplicationArguments(new String[]{}));

        System.out.println(">>>>>>>>>>" + systemOutRule.getLog());

        String message = "Array after sorting: "
                + Arrays.toString(dataProcessor.process(array));
        assertThat(systemOutRule.getLog().contains(message), is(true));
    }

}