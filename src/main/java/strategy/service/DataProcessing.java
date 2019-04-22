package strategy.service;

import org.bson.types.ObjectId;
import strategy.entity.ArrayEntity;

public interface DataProcessing {
    Iterable<ArrayEntity> getAllArrays();

    ArrayEntity findArrayById(ObjectId id);

    void sortAndSaveArrayOfNumbers(int[] initialArray);

    void modifyArray(ObjectId id, int[] newArray);

    void deleteArray(ObjectId id);
}
