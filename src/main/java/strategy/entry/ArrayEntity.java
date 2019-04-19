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

    private int[] inputtedArray;
    private int[] outputtedArray;
    private Date dateCreated;
    private Date dateModified;

    public ArrayEntity(int[] inputtedArray, Date dateCreated) {
        this.inputtedArray = inputtedArray;
        this.dateCreated = dateCreated;
        outputtedArray = new int[0];
    }

    public ObjectId getId() {
        return id;
    }

    public int[] getInputtedArray() {
        return inputtedArray;
    }

    public int[] getOutputtedArray() {
        return outputtedArray;
    }

    public Date getTimestampCreated() {
        return dateCreated;
    }

    public Date getTimestampModified() {
        return dateModified;
    }

    public void setOutputtedArray(int[] outputtedArray) {
        this.outputtedArray = outputtedArray;
    }

    public void setTimestampModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}
