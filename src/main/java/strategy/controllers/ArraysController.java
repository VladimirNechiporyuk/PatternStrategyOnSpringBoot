package strategy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import strategy.data.RandomDataGenerator;
import strategy.entry.ArrayEntity;
import strategy.spliters.SpliterFromStringToArray;
import strategy.service.SortingDataProcessor;
import strategy.service.SortingDataService;

@RestController
@RequestMapping(path = "/arrays")
public class ArraysController {

    private int arrayLength;

    private int numbersBound;

    @Autowired
    private SortingDataService sortingDataService;

    @Autowired
    private RandomDataGenerator dataGenerator;

    @Autowired
    private SortingDataProcessor dataProcessor;

    @GetMapping(path = "/allArrays")
    public @ResponseBody
    Iterable<ArrayEntity> getAllArrays() {
        return sortingDataService.getAllArrays();
    }

    @PostMapping(path = "/saveArrayOfNumbers/{arrayOfNumbers}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ArrayEntity sortAndSaveArrayOfNumbers(@PathVariable (value = "arrayOfNumbers") String array,
                                                 @RequestBody ArrayEntity arrayEntity) {
        int[] numbersArray = SpliterFromStringToArray.splitStringToIntArray(array, ",");
        return sortingDataService.sortAndSaveArrayOfNumbers(numbersArray);
    }
}
