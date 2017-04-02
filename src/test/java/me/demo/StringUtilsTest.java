package me.demo;

import me.demo.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Admin on 4/2/2017.
 */
@RunWith(Parameterized.class)

public class StringUtilsTest {

    private int output;
    private String input;

    public StringUtilsTest(String input, int output){
        this.input = input;
        this.output = output;
    }
    @Parameterized.Parameters(name = "{index}: the length of \"{0}\" is {1}")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { null, 0 },
                { "A", 1 },
                { "AB", 2},
                { "ab", 0 }
        };
        return Arrays.asList(data);
    }

    @Test
    public void lengthOfString() throws Exception {
        assertEquals(output, StringUtils.lengthOfString(input));
    }

}