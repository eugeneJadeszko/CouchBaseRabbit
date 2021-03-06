package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.service.Calculator;
import by.intexsoft.billing.service.CallRecordBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * This class will build {@link CallRecord} object with unique fields
 */
@Service
public class CallRecordBuilderImpl implements CallRecordBuilder {

    private static int counter = 1;
    private int duration;
    private boolean type;
    private Calculator calculator;
    private int subscriberId;
    private long startTime;
    private long endTime;
    private double price;

    @Autowired
    public CallRecordBuilderImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public CallRecord build() {
        counter++;
        duration = new Random().nextInt(1000000);
        type = new Random().nextBoolean();
        subscriberId = new Random().nextInt(21);
        price = calculator.calculatePriceSingleCall(type, duration);
        startTime = System.currentTimeMillis();
        endTime = startTime + duration;
        return new CallRecord(String.valueOf(counter), subscriberId, startTime, endTime, duration, type, price);
    }
}