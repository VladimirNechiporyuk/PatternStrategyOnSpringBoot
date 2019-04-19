package strategy.entry;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Document(collection = "strategy")
public class ArrayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private ObjectId id;

    @JsonProperty("initialData")
    private int[] initialData;

    @JsonProperty("processingData")
    private int[] processedData;

    @JsonProperty("dataCreated")
    private Date dateCreated;

    public ArrayEntity(int[] initialData, int[] processedData) {
        this.initialData = initialData;
        this.processedData = processedData;
        this.dateCreated = new Date();
    }

    public ObjectId getId() {
        return id;
    }

    public int[] getInitialData() {
        return initialData;
    }

    public int[] getProcessedData() {
        return processedData;
    }

    public Date getTimestampCreated() {
        return dateCreated;
    }

    public void setInitialData(int[] initialData) {
        this.initialData = initialData;
    }

    public void setProcessedData(int[] processedData) {
        this.processedData = processedData;
    }
}
