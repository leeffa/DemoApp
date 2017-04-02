package me.demo.external;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Admin on 4/2/2017.
 */
public class ExternalServiceTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test(timeout = 1000, expected = NullPointerException.class)
    public void processOrder() throws Exception {
        throw new NullPointerException("wrong");
    }

}