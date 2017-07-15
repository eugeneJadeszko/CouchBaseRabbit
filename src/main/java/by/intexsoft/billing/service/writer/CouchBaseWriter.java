package by.intexsoft.billing.service.writer;

import by.intexsoft.billing.model.Caller;
import by.intexsoft.billing.repository.CouchbaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouchBaseWriter {

    @Autowired
    private CouchbaseRepository couchbaseRepository;

    public void writeInBucket(Caller caller) {
        couchbaseRepository.save(caller);
    }
}