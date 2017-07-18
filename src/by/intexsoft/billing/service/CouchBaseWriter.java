package by.intexsoft.billing.service;

import by.intexsoft.billing.model.Subscriber;

public interface CouchBaseWriter {
    void write(Subscriber subscriber);
}