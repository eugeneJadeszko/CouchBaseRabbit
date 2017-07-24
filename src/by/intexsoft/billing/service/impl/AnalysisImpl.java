package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.service.Analysis;
import by.intexsoft.billing.service.Calculator;
import by.intexsoft.billing.service.CallRecordService;
import by.intexsoft.billing.service.QueueWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class AnalysisImpl implements Analysis {

    private QueueWriter queueWriter;
    private Calculator calculator;
    private CallRecordService callRecordService;

    @Autowired
    public AnalysisImpl(QueueWriter queueWriter, Calculator calculator, CallRecordService callRecordService) {
        this.queueWriter = queueWriter;
        this.calculator = calculator;
        this.callRecordService = callRecordService;
    }

    @Override
    @Scheduled
    public void analyseAndReport() {

    }

    private String buildJsonString(int subscriberId, double payBill) {
        return "{\"subscriberId\":\"" + subscriberId + "\",\"payBill\":\"" + payBill +"\"}";
    }
}