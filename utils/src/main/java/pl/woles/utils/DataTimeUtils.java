package pl.woles.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Methods for using the date and time.
 */
public class DataTimeUtils {


    /**
     * Change LocalDateTime to string with format.
     *
     * @param dateTime date with time
     * @param format   format
     * @return date with string
     */
    public static String parseDateTimeToString(LocalDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }
}
