package me.demo;

/**
 * Created by Admin on 4/2/2017.
 */
public class StringUtils {
    public static int lengthOfString(String input) {
        if (input == null) {
            return 0;
        }
        int count = 0;
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }
}
