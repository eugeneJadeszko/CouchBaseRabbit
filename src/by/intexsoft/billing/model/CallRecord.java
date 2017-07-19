package by.intexsoft.billing.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * Class describes call record
 */
@Document
public class CallRecord {

    @Id
    public int id;

    @Field
    public int duration;

    @Field
    public boolean type;

    /**
     * Default constructor for {@link CallRecord}. Creates instance of {@link CallRecord} with default initialized fields
     */
    public CallRecord() {}

    /**
     * Constructor for {@link CallRecord}. Creates instance of {@link CallRecord} with unique fields initialized with input parameters
     * @param id unique id
     * @param duration unique call duration set in milliseconds
     * @param type unique call type. {@link CallRecord#type} can be "true" or "false". If "true" -- local call, else -- regional
     */
    public CallRecord(int id, int duration, boolean type) {
        this.id = id;
        this.duration = duration;
        this.type = type;
    }
}