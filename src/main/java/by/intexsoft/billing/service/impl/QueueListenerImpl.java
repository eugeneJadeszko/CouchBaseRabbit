package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.Subscriber;
import by.intexsoft.billing.service.CouchBaseWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@EnableRabbit
@Service
public class QueueListenerImpl {
    private final ObjectMapper mapper;
    private final CouchBaseWriter couchBaseWriter;

    @Autowired
    public QueueListenerImpl(CouchBaseWriter couchBaseWriter) {
        this.couchBaseWriter = couchBaseWriter;
        mapper = new ObjectMapper();
    }

    @RabbitListener(queues = "queue")
    private void processQueue(String messageFromQueue) {
        convertJsonToObject(messageFromQueue);
    }

    /**
     * Convert input JSON string into SampleDocument object
     *
     * @param messageFromQueue input JSON string from RabbitMQ queue
     */
    private void convertJsonToObject(String messageFromQueue) {
        try {
            Subscriber subscriber = mapper.readValue(messageFromQueue, Subscriber.class);
            saveDocumentInCouchbaseBucket(subscriber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save model in Couchbase bucket using "save" method from (WHICH?) repository
     *
     * @param subscriber Document to write in Couchbase bucket
     */
    private void saveDocumentInCouchbaseBucket(Subscriber subscriber) {
        couchBaseWriter.writeInBucket(subscriber);
    }
}