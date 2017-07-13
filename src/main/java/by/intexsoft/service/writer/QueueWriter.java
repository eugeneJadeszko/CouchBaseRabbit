package by.intexsoft.service.writer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.intexsoft.document.BuilderSampleDoc;

@Component
public class QueueWriter {

	@Autowired
	RabbitTemplate template;
	
	@Autowired
	BuilderSampleDoc sampleDoc;

	public void writeMessage() {
		System.out.println("write message");
		template.convertAndSend("message", sampleDoc.builder());
	}
}