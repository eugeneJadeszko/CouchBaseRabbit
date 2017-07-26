package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.service.CallRecordBuilder;
import by.intexsoft.billing.service.QueueWriter;
import by.intexsoft.billing.util.Utility;
import by.intexsoft.billing.util.impl.FileUtilityImpl;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * This class is for writing messages in RabbitMQ queue
 */
@Service("queueWriter")
@PropertySource(value = "classpath:application.properties")
@EnableScheduling
public class QueueWriterImpl implements QueueWriter {

	private final RabbitTemplate template;
	private CallRecordBuilder callRecordBuilder;
	private ObjectMapper mapper;

	@Value("${rabbitmq.messagesExchange:test}")
	private String messagesExchange;

	@Value("${rabbitmq.messagesRoutingKey}")
	private String messagesRoutingKey;

	@Autowired
	public QueueWriterImpl(RabbitTemplate template, CallRecordBuilder callRecordBuilder) {
		this.template = template;
		this.callRecordBuilder = callRecordBuilder;
		mapper = new ObjectMapper();
	}

	@Scheduled(fixedRate = 5000)
	@Override
	public void writeMessage() {
		try {
			template.convertAndSend(messagesExchange, messagesRoutingKey, convert(callRecordBuilder.build()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeReport(String report) {

	}

	/**
	 * Convert input {@link CallRecord} object into JSON string
	 *
	 * @param callRecord
	 *            {@link CallRecord} object to convert in JSON string
	 *
	 * @return converted JSON string
	 */
	private String convert(CallRecord callRecord) throws JsonProcessingException {
		return mapper.writeValueAsString(callRecord);
	}
}