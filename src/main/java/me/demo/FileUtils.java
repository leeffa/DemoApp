package me.demo;

import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 4/2/2017.
 */
public class FileUtils {
    public static void copyFile(File source, File target, boolean keepSource) {
        try {
            org.apache.commons.io.FileUtils.copyFile(source, target);
            if(!keepSource){
                source.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
