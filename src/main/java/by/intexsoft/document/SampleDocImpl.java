package by.intexsoft.document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * This class describes document which we will write in couchbase.
 * "Expiry = 0" means that document will live in couchbase indefinitely.
 */
@Document(expiry = 0)
public class SampleDocImpl implements SampleDoc {

    @Id
    @Field
    private int id;

    /**
     * Type field. Can store two values: 0 or 1.
     */
    @Field
    private String type;

    @Field
    private String firstName;

    @Field
    private String secondName;

    @Field
    private int age;

    public void SampleDoc() {}

    public SampleDocImpl(int id, String type, String firstName, String secondName, int age) {
        this.id = id;
        this.type = type;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
