package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.service.QueueWriter;
import by.intexsoft.billing.service.SubscriberBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("queueWriter")
public class QueueWriterImpl implements QueueWriter {

	private final 	RabbitTemplate template;
	private SubscriberBuilder subscriberBuilder;

	@Autowired
	public QueueWriterImpl(RabbitTemplate template, SubscriberBuilder subscriberBuilder) {
		this.template = template;
		this.subscriberBuilder = subscriberBuilder;
	}

	public void writeMessage() {
		template.convertAndSend("message", subscriberBuilder.build());
	}
}