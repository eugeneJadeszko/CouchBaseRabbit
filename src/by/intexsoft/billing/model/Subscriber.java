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

    /**
     * Unique {@link Subscriber#id} for {@link Subscriber} object
     */
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    public int id;

    /**
     * {@link Subscriber#firstName} of {@link Subscriber}
     */
    @Field
    public String firstName;

    /**
     * {@link Subscriber#secondName} of {@link Subscriber}
     */
    @Field
    public String secondName;

    /**
     * {@link Subscriber#age} of {@link Subscriber}
     */
    @Field
    public int age;

    /**
     * {@link Subscriber#callRecord} based on {@link CallRecord} object
     */
    @Field
    public CallRecord callRecord;

    /**
     * Default constructor for {@link Subscriber}. Creates instance of {@link Subscriber} with default initialized fields
     */
    public Subscriber(){}

    /**
     * Constructor for {@link Subscriber}. Creates instance of {@link Subscriber} with unique fields initialized with input parameters
     * @param id unique {@link Subscriber#id}
     * @param firstName {@link Subscriber#firstName} of {@link Subscriber}
     * @param secondName {@link Subscriber#secondName} of {@link Subscriber}
     * @param age {@link Subscriber#age} of {@link Subscriber}
     * @param callRecord {@link Subscriber#callRecord} based on {@link CallRecord} object
     */
    public Subscriber(int id, String firstName, String secondName, int age, CallRecord callRecord) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.callRecord = callRecord;
    }
}