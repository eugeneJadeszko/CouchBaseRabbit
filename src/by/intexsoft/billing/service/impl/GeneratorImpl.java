package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.model.Subscriber;
import by.intexsoft.billing.service.CallRecordBuilder;
import by.intexsoft.billing.service.Generator;
import by.intexsoft.billing.service.SubscriberBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is for generate models using {@link SubscriberBuilder#build()} and {@link CallRecordBuilder#build()} methods
 */
@Service
public class GeneratorImpl implements Generator {

    private SubscriberBuilder subscriberBuilder;
    private CallRecordBuilder callRecordBuilder;
    private List<Subscriber> subscribers;

    @Autowired
    public GeneratorImpl(SubscriberBuilder subscriberBuilder, CallRecordBuilder callRecordBuilder) {
        this.subscriberBuilder = subscriberBuilder;
        this.callRecordBuilder = callRecordBuilder;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public List<Subscriber> generateSubscribers(int quantity) {
        for (int i = 0; i < quantity; i++) {
            subscribers.add(subscriberBuilder.build());
        }
        return subscribers;
    }

    @Override
    public CallRecord generateCallRecord() {
        return callRecordBuilder.build();
    }
}