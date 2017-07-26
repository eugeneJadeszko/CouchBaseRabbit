package by.intexsoft.billing.service.impl;

import java.io.File;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import by.intexsoft.billing.service.FileManager;
import by.intexsoft.billing.util.Utility;
import by.intexsoft.billing.util.impl.FileUtilityImpl;

@Service
@PropertySource(value = "classpath:application.properties")
public class FileManagerImpl implements FileManager {
	@Value("${rabbitmq.messagesExchange:test}")
	private String messagesExchange;

	@Value("${rabbitmq.messagesRoutingKey}")
	private String messagesRoutingKey;

	@Autowired
	private RabbitTemplate template;

	Utility utility = new FileUtilityImpl();

	@Override
	public File[] getFiles(String dirPath) {
		File dir = new File(dirPath);
		File[] array = dir.listFiles();
		return array;
	}

	@Override
	public void SendAndMove(String dirPath) {
		int counter = 0;
		for (File item : getFiles(dirPath)) {
			template.convertAndSend(messagesExchange, messagesRoutingKey,
					utility.read(item.getParent(), item.getName()));
			utility.move(item.getParent(), item.getName(), "D:\\work\\dir2");
			if (counter > 5)
				break;
			counter++;
		}
	}

}
