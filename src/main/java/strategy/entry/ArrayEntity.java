package strategy.entry;

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
    private ObjectId id;

    private int[] initialData;
    private int[] processedData;
    private Date dateCreated;
    private Date dateModified;

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

    public Date getTimestampModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}
