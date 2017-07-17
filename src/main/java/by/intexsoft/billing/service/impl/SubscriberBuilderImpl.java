package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.Subscriber;
import by.intexsoft.billing.service.SubscriberBuilder;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * This class will build Subscriber object with unique fields.
 */
@Service
public class SubscriberBuilderImpl implements SubscriberBuilder {

    private static int counter = 0;
    private String randomType = String.valueOf(new Random().nextInt(2));

    /**
     * Build unique Subscriber JSON string
     *
     * @return unique Subscriber JSON string
     */
    public Subscriber build() {
        counter++;
        return new Subscriber(randomType, "Ivan" + counter, "Ivanov" + counter, 4 + counter);
    }
}