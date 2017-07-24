package by.intexsoft.billing.repository;

import by.intexsoft.billing.model.CallRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouchbaseRepository extends CrudRepository<CallRecord, String> {}