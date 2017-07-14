package by.intexsoft.billing.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:application.properties")
public class RabbitMqConfig {

	@Value("${rabbitmq.host}")
	private String hostName;

	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.queue}")
	private String queue;

	@Value("${rabbitmq.routing_key}")
	private String routingKey;

	/**
	 * Настройка соединения с RabbitMQ
	 *
	 * @return {@link ConnectionFactory}
	 */
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(hostName);
		return connectionFactory;
	}

	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		rabbitTemplate.setExchange(exchange);
		return rabbitTemplate;
	}

	/**
	 * Создание очереди "queue"
	 *
	 * @return {@link Queue}
	 */
	@Bean
	public Queue Queue1() {
		return new Queue(queue);
	}

	/**
	 * Создание exchange типа direct
	 *
	 * @return {@link DirectExchange}
	 */
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(exchange);
	}

	/**
	 * Связывание очереди "query" с точкой доступа "exchange-direct" по ключу
	 * "message"
	 *
	 * @return {@link Binding}
	 */
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(Queue1()).to(directExchange()).with(routingKey);
	}

	@Bean(name="rabbitListenerContainerFactory")
	public SimpleRabbitListenerContainerFactory listenerFactory(){
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		return factory;
	}
}