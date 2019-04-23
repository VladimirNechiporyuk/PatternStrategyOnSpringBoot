package strategy.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import strategy.StrategyApp;
import strategy.entity.ArrayEntity;
import strategy.repository.ArrayRepository;
import strategy.service.ProcessingDataService;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = StrategyApp.class)
public class ArraysControllerTest {

    @Autowired
    private ProcessingDataService processingDataService;

    @Autowired
    private ArrayRepository repository;

    @Test
    public void postNewArrayTest() {
        int[] newArray = {5, 3, 1, 6, 2, 4};
        int[] testArray = {1, 2, 3, 4, 5, 6};
        processingDataService.sortAndSaveArrayOfNumbers(newArray);
        List<ArrayEntity> result = repository.findAll();
        assertNotNull(result);
        assertTrue(result.contains(testArray));
    }

    @Test
    public void getAllArraysTest() {
    }
}