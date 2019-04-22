package strategy.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import strategy.entity.ArrayEntity;

@Repository
public interface ArrayRepository extends MongoRepository<ArrayEntity, ObjectId> {
}
