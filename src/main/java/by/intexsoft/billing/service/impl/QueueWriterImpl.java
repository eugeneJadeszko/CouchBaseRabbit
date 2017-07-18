package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.Subscriber;
import by.intexsoft.billing.service.QueueWriter;
import by.intexsoft.billing.service.SubscriberBuilder;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("queueWriter")
public class QueueWriterImpl implements QueueWriter {

	private final RabbitTemplate template;
	private SubscriberBuilder subscriberBuilder;
	private ObjectMapper mapper;

	@Autowired
	public QueueWriterImpl(RabbitTemplate template, SubscriberBuilder subscriberBuilder) {
		this.template = template;
		this.subscriberBuilder = subscriberBuilder;
		mapper = new ObjectMapper();
	}

	/**
	 * Write built unique object in RabbitMQ queue
	 */
	public void writeMessage() {
		convertObjectInJsonAndSave(subscriberBuilder.build());
	}

	/**
	 * Convert input object into JSON string
	 *
	 * @param subscriber object model to convert in JSON and write in RabbitMQ queue
	 */
	private void convertObjectInJsonAndSave(Subscriber subscriber) {
		String JsonString;
		try {
			JsonString = mapper.writeValueAsString(subscriber);
			template.convertAndSend(JsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}