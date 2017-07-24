package by.intexsoft.billing.service;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.model.Subscriber;

import java.util.List;

public interface Generator {

    /**
     * Generate ArrayList of certain quantity {@link Subscriber} objects
     *
     * @param quantity certain quantity of {@link Subscriber} object method must generate
     * @return generated quantity of {@link Subscriber} objects stored in ArrayList
     */
    List<Subscriber> generateSubscribers(int quantity);

    /**
     * Generate single {@link CallRecord} object
     *
     * @return generated single {@link CallRecord} object
     */
    CallRecord generateCallRecord();
}