package by.intexsoft.billing;

import by.intexsoft.billing.config.BeanConfig;
import by.intexsoft.billing.config.CouchBaseConfig;
import by.intexsoft.billing.config.RabbitMqConfig;
import by.intexsoft.billing.service.reader.QueueListenerImpl;
import by.intexsoft.billing.service.writer.QueueWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(CouchBaseConfig.class, RabbitMqConfig.class,
                QueueWriter.class, QueueListenerImpl.class, BeanConfig.class);
    }
}