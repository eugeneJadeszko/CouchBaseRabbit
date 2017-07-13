package by.intexsoft;

import org.springframework.context.annotation.ComponentScan;

import by.intexsoft.service.writer.QueueWriter;

@ComponentScan
public class Runner {
	public static void main(String[] args) {
		QueueWriter writer = new QueueWriter();
		System.out.println("Hello World!");
		for (int i = 0; i < 5; i++) {
		writer.writeMessage();	
		}
	}
}