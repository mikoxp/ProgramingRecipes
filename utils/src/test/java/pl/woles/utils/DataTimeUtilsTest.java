package pl.woles.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataTimeUtilsTest {

    private final static String FORMAT_WITH_MINUTES = "dd-MM-yyyy HH:mm";
    private final static String TIMEZONE_UTC = "UTC";
    private final static String TIMEZONE_PLUS_4 = "Etc/GMT-4";
    private LocalDateTime localDateTime_1;
    private String stringDateTime_1;

    @Before
    public void setUp() {
        localDateTime_1 = LocalDateTime.of(2019, 1, 1, 1, 1);
        stringDateTime_1 = "01-01-2019 01:01";
    }

    @After
    public void tearDown() {
    }

    @Test
    public void parseDateTimeToString_correctFormat_string() {
        String result = DataTimeUtils.parseDateTimeToString(localDateTime_1, FORMAT_WITH_MINUTES);
        Assert.assertEquals(stringDateTime_1, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateTimeToString_noCorrectFormat_string() {
        DataTimeUtils.parseDateTimeToString(localDateTime_1, "abc");
    }

    @Test
    public void parseStringToLocalDateTime_correctData() {
        final LocalDateTime result = DataTimeUtils.parseStringToLocalDateTime(stringDateTime_1, FORMAT_WITH_MINUTES);
        Assert.assertEquals(localDateTime_1, result);
    }

    @Test
    public void setDateToZone_changeDate_zoneIdVersion() {
        ZoneId actual = ZoneId.of(TIMEZONE_PLUS_4);
        ZoneId destination = ZoneId.of(TIMEZONE_UTC);
        final LocalDateTime expected = localDateTime_1.minusHours(4);
        final LocalDateTime result = DataTimeUtils.setDateToZone(localDateTime_1, actual, destination);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void setDateToZone_changeDate_stringVersion() {
        final LocalDateTime expected = localDateTime_1.plusHours(4);
        final LocalDateTime result = DataTimeUtils.setDateToZone(localDateTime_1, TIMEZONE_UTC, TIMEZONE_PLUS_4);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void toMiliseconds(){
        final LocalDateTime now = LocalDateTime.now();
        final ZonedDateTime zonedDateTime = now.atZone(ZoneOffset.UTC);
        final long expected = zonedDateTime.toInstant().toEpochMilli();
        final long result = DataTimeUtils.toMiliseconds(zonedDateTime);
        Assert.assertEquals(expected, result);
    }
}