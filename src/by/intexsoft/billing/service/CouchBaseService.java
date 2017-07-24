package by.intexsoft.billing.service;

import by.intexsoft.billing.model.CallRecord;

import java.util.List;

public interface CouchBaseService {

    /**
     * Write input {@link CallRecord} object in Couchbase bucket
     *
     * @param callRecord {@link CallRecord} object
     */
    void write(CallRecord callRecord);

    /**
     * Read node from Couchbase and return {@link CallRecord} object
     *
     * @return {@link CallRecord} object
     */
    List<CallRecord> read(int subscriberId);
}