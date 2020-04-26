package pl.woles.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class DataTimeUtilsTest {

    private String format_1;
    private LocalDateTime localDateTime;
    private String stringDateTime;

    @Before
    public void setUp() {
        format_1="dd-MM-yyyy HH:mm";
        localDateTime = LocalDateTime.of(2019, 1, 1, 1, 1);
        stringDateTime="01-01-2019 01:01";
    }

    @After
    public void tearDown() {
    }

    @Test
    public void parseDateTimeToString_correctFormat_string(){
        String result = DataTimeUtils.parseDateTimeToString(localDateTime, format_1);
        Assert.assertEquals(stringDateTime,result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDateTimeToString_noCorrectFormat_string(){
        DataTimeUtils.parseDateTimeToString(localDateTime, "abc");
    }
}