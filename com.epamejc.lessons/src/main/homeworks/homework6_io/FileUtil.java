package homeworks.homework6_io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class FileUtil {
    private String testFileName = "test.txt";
    private String testBufFileName = "temp _buf.txt";
    private String testStreamFileName = "temp_text.txt";

    public String compareSpeed() {
        File testFile = new File(testFileName);
        createFile(testFile);
        Date dateStBuf = new Date();
        bufferedRead(testFile);
        Date dateEndBuf = new Date();
        Date dateStStr = new Date();
        read(testFile.getName());
        Date dateEndStr = new Date();

        int bufTime = getDuration(dateStBuf, dateEndBuf);
        int streamTime = getDuration(dateStStr, dateEndStr);
        String stream = bufTime > streamTime ? "Buffered" : "Stream";
        int difference = Math.abs(bufTime - streamTime) / 1000;

        return String.format("%s slower. Difference is %s seconds", stream, difference);
    }

    private void createFile(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            final String sp = System.lineSeparator();
            writer.write(makeRandomText() + sp);
            writer.flush();
            System.out.println("File created!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String makeRandomText() {
        return IntStream
                .range(0, 20000)
                .mapToObj(i -> makeRandomLane() + "\r\n")
                .collect(Collectors.joining());
    }

    private String makeRandomLane() {
        return IntStream
                .range(0, 50)
                .mapToObj(i -> String.valueOf(makeRandomChar()))
                .collect(Collectors.joining());
    }

    private char makeRandomChar() {
        Random r = new Random();
        return (char) (r.nextInt(26) + 'a');
    }

    private void bufferedRead(File file) {
        File ForBuf = new File(testBufFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(ForBuf))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
            writer.flush();
            System.out.println("Buffered done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void read(String fileName) {
        File noBuf = new File(testStreamFileName);
        try (FileInputStream stream = new FileInputStream(fileName);
             FileOutputStream outputStream = new FileOutputStream(noBuf)) {
            while (stream.available() > 0) {
                outputStream.write(stream.read());
            }
            outputStream.flush();
            System.out.println("Stream done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getDuration(Date start, Date end) {
        return (int) (end.getTime() - start.getTime());
    }

}
