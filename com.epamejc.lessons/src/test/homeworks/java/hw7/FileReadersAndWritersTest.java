package homeworks.java.hw7;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FileReadersAndWritersTest {

    private File fileToFirstWrite;
    private File fileToRewrite;

    private FilesWriter filesWriter;
    private FilesReaderAndRewriter filesReaderAndRewriter;

    private static String text = "Hello, dear! Have a seat and let's talk.";

    @Before
    public void setUp() throws Exception {
        filesWriter = new FilesWriter();
        filesReaderAndRewriter = new FilesReaderAndRewriter();
    }

    @After
    public void tearDown() throws Exception {
        fileToFirstWrite.delete();
        if (fileToRewrite != null) {
            fileToRewrite.delete();
        }
    }

    @Test
    @SneakyThrows
    public void writeByBytes() {
        filesWriter.writeByBytes();
        fileToFirstWrite = new File("fileoutputstreamtext.txt");

        Scanner scanner = new Scanner(new FileReader(fileToFirstWrite));
        assertTrue(fileToFirstWrite.exists());
        assertTrue(scanner.nextLine().contains(text));
        scanner.close();
    }

    @Test
    @SneakyThrows
    public void writeWithBuffer() {
        filesWriter.writeWithBuffer();
        fileToFirstWrite = new File("bufferedoutputstreamtext.txt");

        Scanner scanner = new Scanner(new FileReader(fileToFirstWrite));

        assertTrue(fileToFirstWrite.exists());
        assertTrue(scanner.nextLine().contains(text));

        scanner.close();
    }

    @Test
    @SneakyThrows
    public void writeFileByFileWriter() {
        filesWriter.writeFileByFileWriter();
        fileToFirstWrite = new File("fileWriter.txt");

        Scanner scanner = new Scanner(new FileReader(fileToFirstWrite));

        assertTrue(fileToFirstWrite.exists());
        assertTrue(scanner.nextLine().contains(text));

        scanner.close();
    }

    @Test
    @SneakyThrows
    public void writeFileWithBufferedWriter() {
        filesWriter.writeFileWithBufferedWriter();
        fileToFirstWrite = new File("bufferedWriterFile.txt");

        Scanner scanner = new Scanner(new FileReader(fileToFirstWrite));

        assertTrue(fileToFirstWrite.exists());
        assertTrue(scanner.nextLine().contains(text));

        scanner.close();
    }


    @Test
    @SneakyThrows
    public void readAndRewriteByBytes() {
        filesWriter.writeByBytes();
        filesReaderAndRewriter.readAndRewriteByBytes();

        fileToFirstWrite = new File("fileoutputstreamtext.txt");
        fileToRewrite = new File("fileoutputstreamtext_new.txt");

        Scanner scanner = new Scanner(new FileReader(fileToFirstWrite));
        assertTrue(fileToFirstWrite.exists());
        assertTrue(scanner.nextLine().contains(text));
        scanner.close();

        Scanner scanner2 = new Scanner(new FileReader(fileToRewrite));
        assertTrue(fileToRewrite.exists());
        assertTrue(scanner2.nextLine().contains(text));
        scanner2.close();

        assertEquals(fileToFirstWrite.length(), fileToRewrite.length());
    }

    @Test
    @SneakyThrows
    public void readAndRewriteByBuffer() {
        filesWriter.writeWithBuffer();
        filesReaderAndRewriter.readAndRewriteByBuffer();

        fileToFirstWrite = new File("bufferedoutputstreamtext.txt");
        fileToRewrite = new File("bufferedoutputstreamtext_new.txt");

        Scanner scanner = new Scanner(new FileReader(fileToFirstWrite));
        assertTrue(fileToFirstWrite.exists());
        assertTrue(scanner.nextLine().contains(text));
        scanner.close();

        Scanner scanner2 = new Scanner(new FileReader(fileToRewrite));
        assertTrue(fileToRewrite.exists());
        assertTrue(scanner2.nextLine().contains(text));
        scanner2.close();

        assertEquals(fileToFirstWrite.length(), fileToRewrite.length());
    }

    @Test
    @SneakyThrows
    public void readAndRewriteByFileReaderWriter() {
        filesWriter.writeFileByFileWriter();
        filesReaderAndRewriter.readAndRewriteByFileReaderWriter();

        fileToFirstWrite = new File("fileWriter.txt");
        fileToRewrite = new File("fileWriter_new.txt");

        Scanner scanner = new Scanner(new FileReader(fileToFirstWrite));
        assertTrue(fileToFirstWrite.exists());
        assertTrue(scanner.nextLine().contains(text));
        scanner.close();

        Scanner scanner2 = new Scanner(new FileReader(fileToRewrite));
        assertTrue(fileToRewrite.exists());
        assertTrue(scanner2.nextLine().contains(text));
        scanner2.close();

        assertEquals(fileToFirstWrite.length(), fileToRewrite.length());
    }

    @Test
    @SneakyThrows
    public void readAndRewriteByBufferedReaderWriter() {
        filesWriter.writeFileWithBufferedWriter();
        filesReaderAndRewriter.readAndRewriteByBufferedReaderWriter();

        fileToFirstWrite = new File("bufferedWriterFile.txt");
        fileToRewrite = new File("bufferedWriterFile_new.txt");

        Scanner scanner = new Scanner(new FileReader(fileToFirstWrite));
        assertTrue(fileToFirstWrite.exists());
        assertTrue(scanner.nextLine().contains(text));
        scanner.close();

        Scanner scanner2 = new Scanner(new FileReader(fileToRewrite));
        assertTrue(fileToRewrite.exists());
        assertTrue(scanner2.nextLine().contains(text));
        scanner2.close();

        assertEquals(fileToFirstWrite.length(), fileToRewrite.length());
    }

}
