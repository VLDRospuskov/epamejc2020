package homeworks.homework7;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileCopierTest {

    private static FileCopier fileCopier;
    private static File fileToCopy;
    private static File fileToSave;

    @BeforeClass
    public static void setup() {
        fileCopier = new FileCopier();
        fileToCopy =
                new File("D:\\Codding\\epamejc2020\\com.epamejc.lessons\\src\\test\\resources\\file.txt");
        fileToSave =
                new File("D:\\Codding\\epamejc2020\\com.epamejc.lessons\\src\\test\\resources\\file copy.txt");
    }

    @Test
    public void testCopier() {
        fileCopier.copyFile(fileToCopy, fileToSave);
        StringBuilder expected = new StringBuilder();
        expected.append("My name is Sergey!");
        StringBuilder actual = new StringBuilder();

        try(FileReader reader = new FileReader(fileToSave)) {

            while (reader.ready()) {
                actual.append((char) reader.read());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Assert.assertEquals(expected.toString(), actual.toString());
    }

}