package by.intexsoft.billing.service;

public interface QueueListener {

    /**
     * Listen set queue and handle input messages
     *
     * @param messageFromQueue input string message in JSON format
     */
    void processQueue(String messageFromQueue);
}