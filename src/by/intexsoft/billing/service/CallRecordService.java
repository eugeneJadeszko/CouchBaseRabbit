package by.intexsoft.billing.service;

import by.intexsoft.billing.model.CallRecord;

import java.util.List;

public interface CallRecordService {

    /**
     * Write input {@link CallRecord} object in Couchbase bucket
     *
     * @param callRecord {@link CallRecord} object
     */
    void write(CallRecord callRecord);

    /**
     * Read nodes from Couchbase and return list of {@link CallRecord} objects
     *
     * @return {@link CallRecord} object
     */
    List<CallRecord> findBySubscriberId(int subscriberId);

    /**
     * Find node by {@link CallRecord#subscriberId} and return {@link CallRecord} object
     *
     * @param subscriberId unique {@link CallRecord#subscriberId} which wire with certain call record
     * @return {@link CallRecord} object
     */
    CallRecord findOne(String subscriberId);
}