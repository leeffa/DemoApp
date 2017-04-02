package me.demo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by Admin on 4/2/2017.
 */
public class MyServiceTest2 {
    MyService myService = new MyService();

    @BeforeClass
    public static void beforeClazz() {
        System.out.print("This is before class 2");
    }

    @AfterClass
    public static void afterClazz() {
        System.out.print("This is after class 2");
    }
    @Test
    public void testProcessOrderShouldFailed() throws Exception {
        assertFalse(myService.processOrder(new Order()));
    }
}