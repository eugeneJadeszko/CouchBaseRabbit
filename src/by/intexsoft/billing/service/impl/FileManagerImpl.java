package by.intexsoft.billing.service.impl;

import java.io.File;
import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import by.intexsoft.billing.service.FileManager;
import by.intexsoft.billing.util.Utility;
import by.intexsoft.billing.util.impl.FileUtilityImpl;
import ch.qos.logback.classic.Logger;

/**
 * This class works with files. Reads messages from files in one directory,
 * sends them to the queue and moves them to the directory of read messages.
 */
@Service
@PropertySource(value = "classpath:application.properties")
public class FileManagerImpl implements FileManager {
	static Logger logger = (Logger) LoggerFactory.getLogger(FileManagerImpl.class.getName());
	@Value("${rabbitmq.messagesExchange:test}")
	private String messagesExchange;

	@Value("${rabbitmq.messagesRoutingKey}")
	private String messagesRoutingKey;

	@Value("${directory.incoming}")
	private String incomingDir;

	@Value("${directory.read}")
	private String readDir;

	@Value("${directory.invalid}")
	private String invalidDir;

	@Value("${files.quantity}")
	private int quantityMessage;

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
	public void SendAndMove() {
		int counter = 0;
		for (File item : getFiles(incomingDir)) {
			try {
				if (utility.isValidJSON(item)) {
					template.convertAndSend(messagesExchange, messagesRoutingKey,
							utility.read(item.getParent(), item.getName()));
					utility.move(item.getParent(), item.getName(), readDir);
					logger.info("read file: " + item.getName());
				} else {
					utility.move(item.getParent(), item.getName(), invalidDir);
					logger.error("invalid file: " + item.getName());
				}
			} catch (IOException e) {
				System.out.println("i/o exception");
			}
			if (++counter >= quantityMessage)
				break;
		}
	}
}
