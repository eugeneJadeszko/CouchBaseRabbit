package by.intexsoft.billing.model;

import org.springframework.data.couchbase.core.mapping.Document;

/**
 * Class describes subscriber which we will write in couchbase bucket
 */
@Document
public class Subscriber {

	/**
	 * Unique {@link Subscriber#id} for {@link Subscriber} object
	 */
	public int id;

	/**
	 * {@link Subscriber#firstName} of {@link Subscriber}
	 */
	public String firstName;

	/**
	 * {@link Subscriber#secondName} of {@link Subscriber}
	 */
	public String secondName;

	/**
	 * {@link Subscriber#callRecord} based on {@link CallRecord} object
	 */
	public int debt;

	/**
	 * Default constructor for {@link Subscriber}. Creates instance of
	 * {@link Subscriber} with default initialized fields
	 */
	public Subscriber() {
	}

	/**
	 * Constructor for {@link Subscriber}. Creates instance of
	 * {@link Subscriber} with unique fields initialized with input parameters
	 * 
	 * @param id
	 *            unique {@link Subscriber#id}
	 * @param firstName
	 *            {@link Subscriber#firstName} of {@link Subscriber}
	 * @param secondName
	 *            {@link Subscriber#secondName} of {@link Subscriber}
	 * 
	 * @param debt
	 *            {@link Subscriber#debt} based on {@link debt}
	 * 
	 */
	public Subscriber(int id, String firstName, String secondName, int debt) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.debt = debt;
	}
}