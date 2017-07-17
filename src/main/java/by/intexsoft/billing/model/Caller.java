package by.intexsoft.billing.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * This class describes model which we will write in couchbase.
 * "Expiry = 0" means that model will live in couchbase indefinitely.
 */
@Document(expiry = 0)
public class Caller {

    @Id
    public int id;

    @Field
    public String type;

    @Field
    public String firstName;

    @Field
    public String secondName;

    @Field
    public int age;

    public void Caller() {}

    public Caller(int id, String type, String firstName, String secondName, int age) {
        this.id = id;
        this.type = type;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }
}