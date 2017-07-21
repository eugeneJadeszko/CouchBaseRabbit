package by.intexsoft.billing.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * Class describes call record which will write in Couchbase bucket
 */
@Document
public class CallRecord {

    /**
     * Unique {@link CallRecord#callId} for {@link CallRecord} model
     */
    @Id
    public int callId;

    /**
     * Unique {@link CallRecord#subscriberId} which refer on certain {@link Subscriber} in OracleDB
     */
    @Field
    public int subscriberId;

    /**
     * {@link CallRecord#startTime} of certain call which stored in milliseconds
     */
    @Field
    public long startTime;

    /**
     * {@link CallRecord#endTime} of certain call which stored in milliseconds
     */
    @Field
    public long endTime;

    /**
     * Call {@link CallRecord#duration} time of single call which stored if milliseconds
     */
    @Field
    public long duration;

    /**
     * Call {@link CallRecord#type}. {@link CallRecord#type} can be "true" or "false". If "true" -- local call, else -- regional
     */
    @Field
    public boolean type;

    /**
     * {@link CallRecord#price} of single call
     */
    @Field
    public double price;

    /**
     * Default constructor for {@link CallRecord}. Creates instance of {@link CallRecord} with default initialized fields
     */
    public CallRecord() {}

    /**
     * Constructor for {@link CallRecord}. Creates instance of {@link CallRecord} with fields initialized with input parameters
     *
     * @param callId unique {@link CallRecord#callId} for {@link CallRecord} model
     * @param subscriberId unique {@link CallRecord#subscriberId} which refer on certain {@link Subscriber} in OracleDB
     * @param startTime {@link CallRecord#endTime} of certain call which stored in milliseconds
     * @param endTime {@link CallRecord#endTime} of certain call which stored in milliseconds
     * @param duration call {@link CallRecord#duration} time of single call which stored if milliseconds
     * @param type Call {@link CallRecord#type}. {@link CallRecord#type} can be "true" or "false". If "true" -- local call, else -- regional
     * @param price {@link CallRecord#price} of single call
     */
    public CallRecord(int callId, int subscriberId, long startTime, long endTime, long duration, boolean type, double price) {
        this.callId = callId;
        this.subscriberId = subscriberId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.type = type;
        this.price = price;
    }
}