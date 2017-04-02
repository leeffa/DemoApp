package me.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Admin on 4/2/2017.
 */
public class FileUtilsTest {
    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    File source;
    File target;

    @Before
    public void setUp() throws IOException {
        source = folder.newFile("myfile.txt");
        target = new File("output.txt");
    }


    @Test
    public void testCopyFileKeepSourceFile() throws Exception {
        assertTrue(source.exists());
        assertFalse(target.exists());

        FileUtils.copyFile(source, target, true);

        assertTrue(source.exists());
        assertTrue(target.exists());

    }
    @Test
    public void testCopyFileNotKeepSourceFile() throws Exception {
        assertTrue(source.exists());
        assertFalse(target.exists());

        FileUtils.copyFile(source, target, false);

        assertFalse(source.exists());
        assertTrue(target.exists());

    }
    @After
    public void clean(){
       target.delete();
    }
}