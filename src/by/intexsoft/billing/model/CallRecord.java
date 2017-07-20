package by.intexsoft.billing.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * Class describes call record
 */
@Document
public class CallRecord {

    /**
     * Unique {@link CallRecord#id} for {@link CallRecord} object
     */
    @Id
    public int id;

    /**
     * Call {@link CallRecord#duration} time which stored if milliseconds
     */
    @Field
    public int duration;

    /**
     * Call {@link CallRecord#type}. {@link CallRecord#type} can be "true" or "false". If "true" -- local call, else -- regional
     */
    @Field
    public boolean type;

    /**
     * Default constructor for {@link CallRecord}. Creates instance of {@link CallRecord} with default initialized fields
     */
    public CallRecord() {}

    /**
     * Constructor for {@link CallRecord}. Creates instance of {@link CallRecord} with unique fields initialized with input parameters
     * @param id unique {@link CallRecord#id}
     * @param duration unique call {@link CallRecord#duration} set in milliseconds
     * @param type call {@link CallRecord#type}. {@link CallRecord#type} can be "true" or "false". If "true" -- local call, else -- regional
     */
    public CallRecord(int id, int duration, boolean type) {
        this.id = id;
        this.duration = duration;
        this.type = type;
    }
}