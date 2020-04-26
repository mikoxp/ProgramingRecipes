package pl.woles.utils;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CollectionsUtilsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmpty_null_true(){
        final boolean empty = CollectionsUtils.isEmpty(null);
        Assert.assertTrue(empty);
    }

    @Test
    public void isEmpty_empty_true(){
        final boolean empty = CollectionsUtils.isEmpty(new ArrayList());
        Assert.assertTrue(empty);
    }

    @Test
    public void isEmpty_noEmpty_false(){
        List<Integer> integers=new ArrayList<>();
        integers.add(1);
        final boolean empty = CollectionsUtils.isEmpty(integers);
        Assert.assertFalse(empty);
    }
}