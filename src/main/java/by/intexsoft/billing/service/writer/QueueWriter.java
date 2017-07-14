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
		System.out.println("11111");
		template.convertAndSend("message", "{\"id\":\"1\",\"type\":\"0\",\"firstName\":\"A\",\"secondName\":\"B\",\"age\":\"22\"}");
	}
}