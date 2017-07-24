package by.intexsoft.billing.service;

import by.intexsoft.billing.model.CallRecord;

public interface CouchBaseWriter {
    void write(CallRecord callRecord);
}