package by.intexsoft.billing.service;

import by.intexsoft.billing.model.CallRecord;

public interface QueueWriter {

    /**
     * Write built unique {@link CallRecord} object in RabbitMQ queue
     */
    void writeMessage();
}