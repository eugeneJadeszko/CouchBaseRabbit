package by.intexsoft.service.writer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import by.intexsoft.document.SampleDoc;
import by.intexsoft.document.BuilderSampleDocImpl;

@Controller
public class QueueWriter {

	@Autowired
	RabbitTemplate template;
	
	@Autowired
	SampleDoc sampleDoc;

	private void writeMessage() {
		template.convertAndSend("message", sampleDoc.builder);
	}
}
