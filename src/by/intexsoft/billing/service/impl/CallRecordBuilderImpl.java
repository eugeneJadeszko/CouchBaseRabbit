package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.service.CallRecordBuilder;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * This class will build {@link CallRecord} object with unique fields
 */
@Service
public class CallRecordBuilderImpl implements CallRecordBuilder {

    private static int counter = 1;
    private int duration = new Random().nextInt(1000000);
    private boolean type = new Random().nextBoolean();

    /**
     * Build unique {@link CallRecord} object
     *
     * @return unique {@link CallRecord} object
     */
    public CallRecord build() {
        counter++;
        return new CallRecord(counter, duration, type);
    }
}