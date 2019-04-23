package strategy.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import strategy.entity.ArrayEntity;
import strategy.service.ProcessingDataService;

@RestController
@RequestMapping(path = "/arrays")
public class ArraysController {

    @Autowired
    private ProcessingDataService processingDataService;

    @GetMapping
    @ResponseBody
    public Iterable<ArrayEntity> getAllArrays() {
        return processingDataService.getAllArrays();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayEntity getArrayById(
            @PathVariable("id") ObjectId id
    ) {
        return processingDataService.findArrayById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ArrayEntity> sortAndSaveArrayOfNumbers(
            int[] array
    ) {
        processingDataService.sortAndSaveArrayOfNumbers(array);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayEntity> modifyArray(
            @PathVariable("id") ObjectId id,
            int[] newArray
    ) {
        processingDataService.modifyArray(id, newArray);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<ArrayEntity> deleteArray(
            @PathVariable ObjectId id
    ) {
        processingDataService.deleteArray(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
