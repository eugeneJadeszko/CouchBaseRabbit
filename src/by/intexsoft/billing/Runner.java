package by.intexsoft.billing;

import by.intexsoft.billing.service.QueueWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext("by.intexsoft.billing.config");
        QueueWriter queueWriter = (QueueWriter) context.getBean("queueWriter");
        queueWriter.writeMessage();
    }
}