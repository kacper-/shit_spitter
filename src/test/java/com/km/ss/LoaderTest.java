package com.km.ss;

import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.util.List;

public class LoaderTest {

    @Test
    public void testReadFromPath() {
        URL resourceUrl = LoaderTest.class.getResource("/test1.txt");
        List<String> list = Loader.readFromPath(resourceUrl.getFile());
        Assert.assertEquals(17, list.size());
    }
}