package by.intexsoft.billing.service.writer;

import by.intexsoft.billing.service.builder.CallerBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueWriter {

	@Autowired
	RabbitTemplate template;

	CallerBuilder callerBuilder;

	public void writeMessage() {
		template.convertAndSend("message", callerBuilder.builder());
	}
}