package by.intexsoft.billing.service;

public interface TimeFormat {

    /**
     * Convert milliseconds in seconds stored in String
     *
     * @param millisecond input call time duration in milliseconds
     * @return call time duration in seconds
     */
    String formatSeconds(long millisecond);

    /**
     * Convert milliseconds in format hh:mm:ss stored in String
     *
     * @param milliseconds input start/end call time
     * @return start/end call time in format hh:mm:ss stored in String
     */
    String standartTimeFormat(long milliseconds);
}