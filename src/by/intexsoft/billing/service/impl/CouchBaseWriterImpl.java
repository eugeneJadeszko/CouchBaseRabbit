package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.repository.CouchbaseRepository;
import by.intexsoft.billing.service.CouchBaseWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is for writing models in Couchbase buckets
 */
@Service
public class CouchBaseWriterImpl implements CouchBaseWriter {

    private final CouchbaseRepository couchbaseRepository;

    @Autowired
    public CouchBaseWriterImpl(CouchbaseRepository couchbaseRepository) {
        this.couchbaseRepository = couchbaseRepository;
    }

    /**
     * Write input {@link CallRecord} object in Couchbase bucket
     *
     * @param callRecord {@link CallRecord} object
     */
    public void write(CallRecord callRecord) {
        couchbaseRepository.save(callRecord);
    }
}