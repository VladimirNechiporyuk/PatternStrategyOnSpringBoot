package strategy.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import strategy.StrategyApp;
import strategy.service.ProcessingDataService;

import static org.junit.Assert.assertNotNull;

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
    @GetMapping
    public void getAllArraysTest() {
        String dbURL = "http://localhost:8080/arrays";
        String result = restTemplate.getForObject(dbURL, String.class);
        assertNotNull(result);
    }
}