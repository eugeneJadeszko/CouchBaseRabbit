package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.Subscriber;
import by.intexsoft.billing.service.CallRecordBuilder;
import by.intexsoft.billing.service.SubscriberBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * This class will build Subscriber object with unique fields
 */
@Service
public class SubscriberBuilderImpl implements SubscriberBuilder {

    private static int counter = 5;
    private CallRecordBuilder callRecordBuilder = new CallRecordBuilderImpl();

    @Autowired
    public SubscriberBuilderImpl(CallRecordBuilder callRecordBuilder) {
        this.callRecordBuilder = callRecordBuilder;
    }

    /**
     * Build unique Subscriber object
     *
     * @return unique Subscriber object
     */
    public Subscriber build() {
        counter++;
        return new Subscriber(counter, "Ivan" + counter, "Ivanov" + counter, 4 + counter, callRecordBuilder.build());
    }
}