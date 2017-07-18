package by.intexsoft.billing.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * Class describes call record which we will write in Couchbase bucket
 */
@Document
public class CallRecord {

    @Id
    public int id;

    @Field
    public int duration;

    @Field
    public boolean type;

    public CallRecord() {}

    public CallRecord(int id, int duration, boolean type) {
        this.id = id;
        this.duration = duration;
        this.type = type;
    }
}