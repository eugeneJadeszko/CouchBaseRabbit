package by.intexsoft.document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Random;

/**
 * This class will build SampleDoc with unique fields.
 */
public class BuilderSampleDocImpl implements BuilderSampleDoc {

    private static int counter = 0;
    private String randomType = String.valueOf(new Random().nextInt(2));

    /**
     * Build unique SampleDoc JSON sting
     *
     * @return unique SampleDoc JSON sting
     */
    public String builder() {
        counter++;
        return convertDocToJson(new SampleDoc(counter, randomType, "Ivan" + counter, "Ivanov" + counter, 4 + counter));
    }


    /**
     * Convert SampleDoc object into JSON string
     * @param sampleDoc input SampleDoc object
     * @return converted into JSON string SampleDoc object
     */
    private String convertDocToJson(SampleDoc sampleDoc) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(sampleDoc);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }

}
