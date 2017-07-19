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

/**
 * This class is for listen the rabbitmq queue
 */
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
        convertAndSave(messageFromQueue);
    }

    /**
     * Convert input JSON string into Subscriber object
     *
     * @param messageFromQueue input JSON string from RabbitMQ queue
     */
    private void convertAndSave(String messageFromQueue) {
        try {
            save(mapper.readValue(messageFromQueue, Subscriber.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save model in Couchbase bucket using "save" method from repository
     *
     * @param subscriber Document to write in Couchbase bucket
     */
    private void save(Subscriber subscriber) {
        couchBaseWriter.write(subscriber);
    }
}