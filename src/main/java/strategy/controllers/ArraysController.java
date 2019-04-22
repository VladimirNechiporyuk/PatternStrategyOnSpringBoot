package strategy.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import strategy.entity.ArrayEntity;
import strategy.service.ProcessingDataService;

import java.util.Date;

@RestController
@RequestMapping(path = "/arrays")
public class ArraysController {

    private final Log log = LogFactory.getLog(ProcessingDataService.class);

    @Autowired
    private ProcessingDataService processingDataService;

    @GetMapping
    @ResponseBody
    public Iterable<ArrayEntity> getAllArrays() {
        return processingDataService.getAllArrays();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ArrayEntity getArrayById(
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

        Date dateWhenModified = new Date();
        log.info(String.format("Data with id %s was modified at %s",
                id.toString(),
                dateWhenModified.toString()));

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ArrayEntity> deleteArray(
            @PathVariable ObjectId id
    ) {
        processingDataService.deleteArray(id);
        log.info(String.format("Data with id %s deleted", id.toString()));
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
