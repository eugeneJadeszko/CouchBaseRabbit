package by.intexsoft.billing.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

/**
 * This class describes model which we will write in couchbase.
 * "Expiry = 0" means that model will live in couchbase indefinitely.
 */
@Document
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private int id;

    @Field
    private String type;

    @Field
    private String firstName;

    @Field
    private String secondName;

    @Field
    private int age;

    public Subscriber(){}

    public Subscriber( String type, String firstName, String secondName, int age) {
        this.type = type;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }
}