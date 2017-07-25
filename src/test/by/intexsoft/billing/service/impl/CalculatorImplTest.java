package test.by.intexsoft.billing.service.impl;

import static org.testng.Assert.assertEquals;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

import by.intexsoft.billing.service.Calculator;
import by.intexsoft.billing.service.impl.CalculatorImpl;

/**
 * This test class tests the functionality of class calculator methods
 */
public class CalculatorImplTest {
	ApplicationContext context = new AnnotationConfigApplicationContext("by.intexsoft.billing.config");
	Calculator calc = context.getBean(CalculatorImpl.class);

	@Test
	public void calculateCallDuration() {
		long rez = calc.calculateCallDuration(10000, 50000);
		assertEquals(rez, 40000);
	}

	@Test
	public void calculatePriceSingleCall() {
		double rezInternal = calc.calculatePriceSingleCall(true, 20000);
		assertEquals(rezInternal, 0.2, 0.0);
		double rezExternal = calc.calculatePriceSingleCall(false, 20000);
		assertEquals(rezExternal, 0.8, 0.0);
	}
}
