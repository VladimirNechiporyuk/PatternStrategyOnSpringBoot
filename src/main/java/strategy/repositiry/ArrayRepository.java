package strategy.repositiry;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import strategy.entry.ArrayEntity;

@Repository
public interface ArrayRepository extends MongoRepository<ArrayEntity, ObjectId> {
    ArrayEntity findByid(ObjectId id);
}
