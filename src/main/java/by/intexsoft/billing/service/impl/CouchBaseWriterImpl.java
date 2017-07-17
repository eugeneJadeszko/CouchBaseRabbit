package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.Subscriber;
import by.intexsoft.billing.repository.CouchbaseRepository;
import by.intexsoft.billing.service.CouchBaseWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouchBaseWriterImpl implements CouchBaseWriter {

    private final CouchbaseRepository couchbaseRepository;

    @Autowired
    public CouchBaseWriterImpl(CouchbaseRepository couchbaseRepository) {
        this.couchbaseRepository = couchbaseRepository;
    }

    public void writeInBucket(Subscriber subscriber) {
        couchbaseRepository.save(subscriber);
    }
}