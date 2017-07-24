package by.intexsoft.billing.service;

import by.intexsoft.billing.model.CallRecord;

public interface CallRecordBuilder {

    /**
     * Build unique {@link CallRecord} object
     *
     * @return unique {@link CallRecord} object
     */
    CallRecord build();
}