package by.intexsoft.billing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Scanning beans in base packages
 */
@Configuration
@ComponentScan(basePackages = "by.intexsoft.billing.service.impl")
public class BeanConfig {
}