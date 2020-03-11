package homeworks.homework6_io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FileUtil {
    private String testFileName = "test.txt";
    private String testBufFileName = "temp_buf.txt";
    private String testStreamFileName = "temp_text.txt";
    private String testNioFileName = "temp_byte_array_text.txt";

    public String compareSpeed() {
        createFile();
        int bufDuration = getBufTime();
        int streamTime = getStreamTime();
        int nioTime = getNioTime();
        System.out.printf("BufferedReader copied file in %s milliseconds\n", bufDuration);
        System.out.printf("OutputStream copied file in %s milliseconds\n", streamTime);
        System.out.printf("Files copied file in %s milliseconds\n", nioTime);
        String stream = bufDuration > streamTime ? "Buffered" : "Stream";
        int difference = Math.abs(bufDuration - streamTime) / 1000;
        return String.format("%s in Java IO slower. Difference is %s seconds", stream, difference);
    }

    private void createFile() {
        File testFile = new File(testFileName);
        createFile(testFile);
    }

    private int getBufTime() {
        Date dateStartBufferedReader = new Date();
        copyWithBR();
        Date dateEndBufferedReader = new Date();
        return getDuration(dateStartBufferedReader, dateEndBufferedReader);
    }

    private int getStreamTime() {
        Date dateStartStream = new Date();
        copyWithStream();
        Date dateEndStream = new Date();
        return getDuration(dateStartStream, dateEndStream);
    }

    private int getNioTime() {
        Date dateStartNioCopy = new Date();
        copyWithNio();
        Date dateEndNioCopy = new Date();
        return getDuration(dateStartNioCopy, dateEndNioCopy);
    }

    private void copyWithBR() {
        File ForBuf = new File(testBufFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(testFileName)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(ForBuf))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
            System.out.println("Buffered done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void copyWithStream() {
        File noBuf = new File(testStreamFileName);
        try (FileInputStream stream = new FileInputStream(testFileName);
             FileOutputStream outputStream = new FileOutputStream(noBuf)) {
            while (stream.available() > 0) {
                outputStream.write(stream.read());
            }
            System.out.println("Stream done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyWithNio() {
        Path originalPath = Paths.get(testFileName);
        Path toCopy = Paths.get(testNioFileName);
        try {
            Files.copy(originalPath, toCopy, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("NIO done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private int getDuration(Date start, Date end) {
        return (int) (end.getTime() - start.getTime());
    }

}
