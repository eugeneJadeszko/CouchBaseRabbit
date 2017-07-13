package by.intexsoft.service.reader;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.intexsoft.document.SampleDoc;

public class QueueListener {

	@Autowired
	ObjectMapper mapper;

	@RabbitListener(queues = "queue")
	public void listenQueue(String messageJString) throws JsonParseException, JsonMappingException, IOException {
		SampleDoc doc = mapper.readValue(messageJString, SampleDoc.class);
		System.out.println(doc.getId() + " " + doc.getFirstName() + " " + doc.getSecondName() + " " + doc.getAge() + " "
				+ doc.getType());
	}
}
