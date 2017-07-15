package by.intexsoft.billing.config;

import by.intexsoft.billing.service.reader.QueueListenerImpl;
import by.intexsoft.billing.service.writer.CouchBaseWriter;
import by.intexsoft.billing.service.writer.QueueWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "queueWriter")
    public QueueWriter getQueueWriter() {
        return new QueueWriter();
    }

    @Bean(name = "queueListener")
    public QueueListenerImpl getQueueListener() {
        return new QueueListenerImpl();
    }

    @Bean(name = "couchbaseWriter")
    public CouchBaseWriter getCouchbaseWriter() {
        return new CouchBaseWriter();
    }
}