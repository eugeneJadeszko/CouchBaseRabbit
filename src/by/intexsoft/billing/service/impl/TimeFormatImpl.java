package by.intexsoft.billing.service.impl;

import by.intexsoft.billing.service.TimeFormat;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeFormatImpl implements TimeFormat {

    @Override
    public String formatSeconds(long millisecond) {
        return String.valueOf(millisecond / 1000);
    }

    @Override
    public String standartTimeFormat(long milliseconds) {
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(new Date(milliseconds));
    }
}