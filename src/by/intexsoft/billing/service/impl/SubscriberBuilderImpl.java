package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.Subscriber;
import by.intexsoft.billing.service.SubscriberBuilder;
import org.springframework.stereotype.Service;

/**
 * This class will build {@link Subscriber} object with unique fields
 */
@Service
public class SubscriberBuilderImpl implements SubscriberBuilder {

    private static int counter = 5;

    @Override
    public Subscriber build() {
        counter++;
        return new Subscriber(counter, "Ivan" + counter, "Ivanov" + counter, 0);
    }
}