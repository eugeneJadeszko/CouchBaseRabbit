package by.intexsoft.billing.service.builder;

import by.intexsoft.billing.model.Caller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Random;

/**
 * This class will build Caller object with unique fields.
 */
public class CallerBuilderImpl implements CallerBuilder {

    private static int counter = 0;
    private String randomType = String.valueOf(new Random().nextInt(2));

    /**
     * Build unique Caller JSON string
     *
     * @return unique Caller JSON string
     */
    public String builder() {
        counter++;
        return convertDocToJson(new Caller(counter, randomType, "Ivan" + counter, "Ivanov" + counter, 4 + counter));
    }

    /**
     * Convert Caller object into JSON string
     * @param caller input Caller object
     * @return converted into JSON string Caller object
     */
    private String convertDocToJson(Caller caller) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(caller);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}