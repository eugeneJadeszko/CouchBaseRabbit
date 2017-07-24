package by.intexsoft.billing.service;

import by.intexsoft.billing.model.Subscriber;

public interface SubscriberBuilder {

	/**
	 * Build unique {@link Subscriber} object
	 *
	 * @return unique {@link Subscriber} object
	 */
	Subscriber build();
}