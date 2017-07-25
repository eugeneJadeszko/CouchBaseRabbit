package by.intexsoft.billing.service;

public interface Analysis {

    /**
     * Analyse calls every month, create report and write it in RabbitMQ queue.
     * Report included subscriberId and month payBill
     */
    void analyseAndReport();
}