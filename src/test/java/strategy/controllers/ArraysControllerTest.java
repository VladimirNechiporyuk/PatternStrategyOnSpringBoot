package strategy.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import strategy.StrategyApp;
import strategy.service.ProcessingDataService;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = StrategyApp.class)
public class ArraysControllerTest {

    private RestTemplate restTemplate;

    @Autowired
    private ProcessingDataService processingDataService;

    @Before
    public void configurationForTest() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void getAllArraysTest() {
        String dbURL = "http://localhost:8080/arrays";
        String result = restTemplate.getForObject(dbURL, String.class);
        assertNotNull(result);
    }

    @Test
    public void postNewArrayTest() {
        int[] newArray = {5, 3, 1, 6, 2, 4};
        processingDataService.sortAndSaveArrayOfNumbers(newArray);
        String dbURL = "http://localhost:8080/arrays";
        String result = restTemplate.getForObject(dbURL, String.class);
        assertNotNull(result);
        assertTrue(result.contains(Arrays.toString(newArray)));

    }
}