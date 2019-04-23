package strategy.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Document(collection = "strategy")
@Data
public class ArrayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private ObjectId id;

    @JsonProperty("initialData")
    private int[] initialData;

    @JsonProperty("processingData")
    private int[] processedData;

    @JsonProperty("dataCreated")
    private Date dateCreated;

    @JsonProperty("dataModified")
    private Date modifiedData;

    public ArrayEntity() {
        this.dateCreated = new Date();
    }

    public ArrayEntity(int[] initialData, int[] processedData) {
        this.initialData = initialData;
        this.processedData = processedData;
        this.dateCreated = new Date();
        this.modifiedData = new Date();
    }

    public void setProcessedData(int[] processedData) {
        this.processedData = processedData;
        this.modifiedData = new Date();
    }
}