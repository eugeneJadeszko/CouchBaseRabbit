package by.intexsoft.billing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import by.intexsoft.billing.service.FileManager;
import by.intexsoft.billing.service.QueueWriter;

/**
 * This class is for writing messages in RabbitMQ queue
 */
@Service("queueWriter")
@PropertySource(value = "classpath:application.properties")
@EnableScheduling
public class QueueWriterImpl implements QueueWriter {

	@Autowired
	private FileManager fileManager;

	@Scheduled(fixedRate = 5000)
	@Override
	public void writeMessage() {
		fileManager.SendAndMove("D:\\work\\dir1");
	}

	@Override
	public void writeReport(String report) {

	}
}