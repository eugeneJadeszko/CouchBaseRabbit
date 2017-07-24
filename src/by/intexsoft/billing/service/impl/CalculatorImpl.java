package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.service.Calculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is designed to calculate call data
 */
@Service
@PropertySource(value = "classpath:callRates.properties")
public class CalculatorImpl implements Calculator {
	private double payBill = 0;

	@Value("${call.internal:0.01}")
	private double rateInternal;

	@Value("${call.external:0.04}")
	private double rateExternal;

	@Override
	public long calculateCallDuration(long startTime, long endTime) {
		return endTime - startTime;
	}

	@Override
	public double calculatePriceSingleCall(boolean type, long duraction) {
		return duraction / 1000 * (type ? rateInternal : rateExternal);
	}

	@Override
	public double calculateSumPriceCalls(List<CallRecord> list) {
		payBill = 0;
		list.forEach((CallRecord count) -> payBill += count.price);
		return payBill;
	}
}
