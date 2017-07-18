package by.intexsoft.billing.service;

public interface QueueListener {
    void processQueue(String messageFromQueue);
}