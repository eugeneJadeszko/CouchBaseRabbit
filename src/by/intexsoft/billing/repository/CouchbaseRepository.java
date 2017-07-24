package by.intexsoft.billing.repository;

import by.intexsoft.billing.model.CallRecord;
import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouchbaseRepository extends CrudRepository<CallRecord, String> {

    @View(designDocument = "call_record", viewName = "bySubscriberId")
    List<CallRecord> findBySubscriberId(int subscriberId);
}