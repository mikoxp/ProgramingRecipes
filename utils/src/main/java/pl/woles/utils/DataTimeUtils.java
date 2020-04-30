package pl.woles.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Methods for using the date and time.
 */
public class DataTimeUtils {

    public final static String FORMAT_WITH_HOURS = "dd-MM-yyyy HH:mm";
    public final static String FORMAT_ONLY_DATE = "dd-MM-yyyy";

    /**
     * Change LocalDateTime to string with format.
     *
     * @param dateTime date with time
     * @param format format
     * @return date with string
     */
    public static String parseDateTimeToString(LocalDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }

    /**
     * Change string to LocalDateTime  with format.
     *
     * @param dateTime string datetime
     * @param format format
     * @return localdatetime
     */
    public static LocalDateTime parseStringToLocalDateTime(String dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateTime, formatter);
    }

    /**
     * @param localDateTime localDateTime
     * @param actualZone actual zone
     * @param destinationZone destination zone
     * @return datetime with zone
     */
    public static LocalDateTime setDateToZone(LocalDateTime localDateTime, String actualZone, String destinationZone) {
        ZoneId actual = ZoneId.of(actualZone);
        ZoneId destination = ZoneId.of(destinationZone);
        return setDateToZone(localDateTime, actual, destination);
    }

    /**
     * @param localDateTime localDateTime
     * @param actualZone actual zone
     * @param destinationZone destination zone
     * @return datetime with zone
     */
    public static LocalDateTime setDateToZone(LocalDateTime localDateTime, ZoneId actualZone, ZoneId destinationZone) {
        return localDateTime.atZone(actualZone).withZoneSameInstant(destinationZone).toLocalDateTime();
    }

    public static long toMiliseconds(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toInstant().toEpochMilli();
    }

}
