package by.intexsoft.billing.service.reader;

import by.intexsoft.billing.model.Caller;
import by.intexsoft.billing.repository.CouchbaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@EnableRabbit
@Component
public class QueueListenerImpl {

    @Autowired
    CouchbaseRepository couchbaseRepository;

    @RabbitListener(queues = "queue")
    public void processQueue(String messageFromQueue) {
        convertJsonToObject(messageFromQueue);
    }

    /**
     * Convert input JSON string into SampleDocument object
     *
     * @param messageFromQueue input JSON string from RabbitMQ queue
     */
    private void convertJsonToObject(String messageFromQueue) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Caller caller = mapper.readValue(messageFromQueue, Caller.class);
            saveDocumentInCouchbaseBucket(caller);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save model in Couchbase bucket using "save" method from (WHICH?) repository
     *
     * @param caller Document to write in Couchbase bucket
     */
    private void saveDocumentInCouchbaseBucket(Caller caller) {
        couchbaseRepository.save(caller);
    }
}