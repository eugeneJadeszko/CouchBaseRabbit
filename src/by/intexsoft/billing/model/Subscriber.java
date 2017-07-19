package by.intexsoft.billing.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

/**
 * Class describes subscriber which we will write in couchbase bucket
 */
@Document
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    public int id;

    @Field
    public String firstName;

    @Field
    public String secondName;

    @Field
    public int age;

    @Field
    public CallRecord callRecord;

    /**
     * Default constructor for {@link Subscriber}. Creates instance of {@link Subscriber} with default initialized fields
     */
    public Subscriber(){}

    /**
     * Constructor for {@link Subscriber}. Creates instance of {@link Subscriber} with unique fields initialized with input parameters
     * @param id unique id
     * @param firstName unique first name of subscriber
     * @param secondName unique second name of subscriber
     * @param age unique age of subscriber
     * @param callRecord unique call record based on {@link CallRecord} object
     */
    public Subscriber(int id, String firstName, String secondName, int age, CallRecord callRecord) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.callRecord = callRecord;
    }
}