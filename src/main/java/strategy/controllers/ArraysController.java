package strategy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import strategy.entry.ArrayEntity;
import strategy.service.ProcessingDataService;

@RestController
@RequestMapping(path = "/arrays")
public class ArraysController {

    @Autowired
    private ProcessingDataService processingDataService;

    @GetMapping
    public @ResponseBody
    Iterable<ArrayEntity> getAllArrays() {
        return processingDataService.getAllArrays();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ArrayEntity sortAndSaveArrayOfNumbers(int[] array) {
        return processingDataService.sortAndSaveArrayOfNumbers(array);
    }

//    @DeleteMapping
//    public void deleteArray(int[] array) {
//        return processingDataService.deleteArray(array);
//    }
}
