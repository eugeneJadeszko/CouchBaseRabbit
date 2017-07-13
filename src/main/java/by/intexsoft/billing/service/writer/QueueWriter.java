package by.intexsoft.billing.service.writer;

import by.intexsoft.billing.service.builder.CallerBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.intexsoft.document.BuilderSampleDoc;

@Component
public class QueueWriter {

	@Autowired
	RabbitTemplate template;
	
	@Autowired
	CallerBuilder sampleDoc;

	public void writeMessage() {
		template.convertAndSend("message", sampleDoc.builder());
	}
}