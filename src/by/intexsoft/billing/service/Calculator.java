package by.intexsoft.billing.service;

import java.util.List;

import by.intexsoft.billing.model.CallRecord;

public interface Calculator {
	/**
	 * Method calculates the duration of the call
	 * 
	 * @param startTime
	 *            - start talk time in milliseconds
	 * @param endTime
	 *            - end time of call in milliseconds
	 * 
	 * @return duration of the call in milliseconds
	 */
	long calculateDuractionCall(long startTime, long endTime);

	/**
	 * The method calculates the payBill of one call
	 * 
	 * @param type
	 *            - type of call (true = internal, false = external)
	 * @param duraction
	 *            - duration of a call in milliseconds
	 * @return the payBill of one call
	 */
	double calculatePriceSingleCall(boolean type, long duraction);

	/**
	 * The method calculates the total payBill for the month
	 * 
	 * @param list
	 *            - Collection of objects CallRecord
	 * @return the payBill for the month
	 */
	double calculateSummPriceCalls(List<CallRecord> list);
}
