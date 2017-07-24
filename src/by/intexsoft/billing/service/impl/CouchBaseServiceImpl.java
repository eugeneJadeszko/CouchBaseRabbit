package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.repository.CouchbaseRepository;
import by.intexsoft.billing.service.CouchBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is for writing models in Couchbase buckets
 */
@Service
public class CouchBaseServiceImpl implements CouchBaseService {

    private final CouchbaseRepository couchbaseRepository;

    @Autowired
    public CouchBaseServiceImpl(CouchbaseRepository couchbaseRepository) {
        this.couchbaseRepository = couchbaseRepository;
    }

    @Override
    public void write(CallRecord callRecord) {
        couchbaseRepository.save(callRecord);
    }

    @Override
    public List<CallRecord> read(int subscriberId) {
        return couchbaseRepository.findBySubscriberId(subscriberId);
    }
}