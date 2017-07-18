package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.service.CallRecordBuilder;

import java.util.Random;

/**
 * This class will build CallRecord object with unique fields
 */
public class CallRecordBuilderImpl implements CallRecordBuilder {

    private static int counter = 1;
    private int duration = new Random().nextInt(1000000);
    private boolean type = new Random().nextBoolean();

    /**
     * Build unique CallRecord JSON string
     *
     * @return unique CallRecord JSON string
     */
    public CallRecord build() {
        counter++;
        return new CallRecord(counter, duration, type);
    }
}