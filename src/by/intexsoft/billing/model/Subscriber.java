package by.intexsoft.billing.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

/**
 * Class describes model which we will write in couchbase
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

    public Subscriber(){}

    public Subscriber(int id, String firstName, String secondName, int age, CallRecord callRecord) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.callRecord = callRecord;
    }
}