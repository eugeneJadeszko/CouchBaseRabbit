package by.intexsoft.billing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configure class. Scanning services in base packages
 */
@Configuration
@ComponentScan(basePackages = "by.intexsoft.billing.service.impl")
public class BeanConfig {
}