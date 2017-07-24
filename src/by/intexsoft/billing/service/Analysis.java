package by.intexsoft.billing.service;

import org.springframework.scheduling.annotation.Scheduled;

public interface Analysis {

    /**
     * Analyse calls every month, create report and write it in RabbitMQ queue.
     * Report included subscriberId and month payBill
     */
    @Scheduled
    void analyseAndReport();
}