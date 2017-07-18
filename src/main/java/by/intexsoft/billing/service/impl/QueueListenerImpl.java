package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.Subscriber;
import by.intexsoft.billing.service.CouchBaseWriter;
import by.intexsoft.billing.service.QueueListener;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@EnableRabbit
@Service
public class QueueListenerImpl implements QueueListener {
    private final CouchBaseWriter couchBaseWriter;
    private final ObjectMapper mapper;

    @Autowired
    public QueueListenerImpl(CouchBaseWriter couchBaseWriter) {
        this.couchBaseWriter = couchBaseWriter;
        mapper = new ObjectMapper();
    }

    @RabbitListener(queues = "queue")
    public void processQueue(String messageFromQueue) {
        convertJsonToObjectAndSave(messageFromQueue);
    }

    /**
     * Convert input JSON string into SampleDocument object
     *
     * @param messageFromQueue input JSON string from RabbitMQ queue
     */
    private void convertJsonToObjectAndSave(String messageFromQueue) {
        try {
            Subscriber subscriber = mapper.readValue(messageFromQueue, Subscriber.class);
            saveInBucket(subscriber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save model in Couchbase bucket using "save" method from (WHICH?) repository
     *
     * @param subscriber Document to write in Couchbase bucket
     */
    private void saveInBucket(Subscriber subscriber) {
        couchBaseWriter.write(subscriber);
    }
}