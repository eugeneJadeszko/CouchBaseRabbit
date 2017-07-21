package by.intexsoft.billing.model;

import org.springframework.data.couchbase.core.mapping.Document;

/**
 * Class describes subscriber which will commit calls
 */
@Document
public class Subscriber {

	/**
	 * Unique {@link Subscriber#subscriberId} for {@link Subscriber} model
	 */
	public int subscriberId;

	/**
	 * {@link Subscriber#firstName} of {@link Subscriber}
	 */
	public String firstName;

	/**
	 * {@link Subscriber#secondName} of {@link Subscriber}
	 */
	public String secondName;

	/**
	 * {@link Subscriber#payBill} for whole month
	 */
	public double payBill;

	/**
	 * Default constructor for {@link Subscriber}. Creates instance of
	 * {@link Subscriber} with default initialized fields
	 */
	public Subscriber() {
	}

	/**
	 * Constructor for {@link Subscriber}. Creates instance of
	 * {@link Subscriber} with fields initialized with input parameters
	 * 
	 * @param subscriberId unique {@link Subscriber#subscriberId}
	 * @param firstName {@link Subscriber#firstName} of {@link Subscriber}
	 * @param secondName {@link Subscriber#secondName} of {@link Subscriber}
	 * @param payBill {@link Subscriber#payBill} for whole month
	 * 
	 */
	public Subscriber(int subscriberId, String firstName, String secondName, int payBill) {
		this.subscriberId = subscriberId;
		this.firstName = firstName;
		this.secondName = secondName;
		this.payBill = payBill;
	}
}