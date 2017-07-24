package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.service.CouchBaseService;
import by.intexsoft.billing.service.QueueListener;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * This class is for listening the RabbitMQ queue
 */
@EnableRabbit
@Service
@PropertySource(value="classpath:application.properties")
public class QueueListenerImpl implements QueueListener {

    private final CouchBaseService couchBaseService;
    private final ObjectMapper mapper;

	@Autowired
    public QueueListenerImpl(CouchBaseService couchBaseService) {
        this.couchBaseService = couchBaseService;
        mapper = new ObjectMapper();
    }

    /**
     * Listen set queue and handle input messages
     *
     * @param messageFromQueue input string message in JSON format
     */
    @RabbitListener(queues = "${rabbitmq.messagesQueue}")
    public void processQueue(String messageFromQueue) {
        convertAndSave(messageFromQueue);
    }

    /**
     * Convert input JSON string into {@link CallRecord} object
     *
     * @param messageFromQueue input JSON string from RabbitMQ queue
     */
    private void convertAndSave(String messageFromQueue) {
        try {
            save(mapper.readValue(messageFromQueue, CallRecord.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save {@link CallRecord} object in Couchbase bucket using "save" method from {@link by.intexsoft.billing.repository.CouchbaseRepository}
     *
     * @param callRecord instance of {@link CallRecord} object to write in Couchbase bucket
     */
    private void save(CallRecord callRecord) {
        couchBaseService.write(callRecord);
    }
}