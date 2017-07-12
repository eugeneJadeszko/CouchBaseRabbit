package by.intexsoft.document;

import java.util.Random;

/**
 * This class will build SampleDoc with unique fields.
 */
public class BuilderSampleDoc {

    private static int counter = 0;
    private String randomType = String.valueOf(new Random().nextInt(2));

    /**
     * Build unique SampleDoc object
     *
     * @return unique SampleDoc object
     */
    public SampleDoc builder() {
        counter++;
        return new SampleDocImpl(counter, randomType, "Ivan" + counter, "Ivanov" + counter, 4 + counter);
    }

}
