package test.by.intexsoft.billing;

import static org.testng.Assert.assertEquals;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.service.impl.CallRecordBuilderImpl;
import by.intexsoft.billing.service.impl.CallRecordServiceImpl;

/**
 * This class tests the application as a whole. An object is created, parsed in
 * JSON, sent to the exchange RabbitMQ, then gets into CoachBase, extracted and
 * compared with the original
 */
public class TestBilling {
	ApplicationContext context = new AnnotationConfigApplicationContext("by.intexsoft.billing.config");
	private CallRecordBuilderImpl builder = context.getBean(CallRecordBuilderImpl.class);
	private CallRecordServiceImpl service = context.getBean(CallRecordServiceImpl.class);
	private ObjectMapper mapper = new ObjectMapper();
	private RabbitTemplate template = (RabbitTemplate) context.getBean("rabbitTemplate");
	private CallRecord buildRecord = builder.build();

	@BeforeMethod
	private void sendToRabbit() throws AmqpException, JsonProcessingException {
		template.convertAndSend("exchange-direct-message", "message", mapper.writeValueAsString(buildRecord));
	}

	@Test
	public void checkDocInCouchBase() throws InterruptedException {
		Thread.sleep(100);
		CallRecord rezultRecord = service.findOne(buildRecord.callId);
		assertEquals(rezultRecord.callId, buildRecord.callId);
		assertEquals(rezultRecord.subscriberId, buildRecord.subscriberId);
		assertEquals(rezultRecord.duration, buildRecord.duration);
		assertEquals(rezultRecord.endTime, buildRecord.endTime);
		assertEquals(rezultRecord.startTime, buildRecord.startTime);
		assertEquals(rezultRecord.type, buildRecord.type);
		assertEquals(rezultRecord.price, buildRecord.price, 0.0);
	}
}
