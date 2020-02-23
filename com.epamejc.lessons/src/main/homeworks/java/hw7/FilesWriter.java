package homeworks.java.hw7;

import java.io.*;

public class FilesWriter {

    private static String text = "Hello, dear! Have a seat and let's talk.";

    public void writeByBytes() {
        String fileName = "D://Studies/Java/InputOutput/fileoutputstreamtext.txt";

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] buffer = text.getBytes();

            for (int i = 0; i < 100000; i++) {
                fos.write(buffer);
            }
            fos.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("File was written with FileOutputStream class.");
    }

    public void writeWithBuffer() {
        String fileName = "D://Studies/Java/InputOutput/bufferedoutputstreamtext.txt";

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName))) {
            byte[] buffer = text.getBytes();
            for (int i = 0; i < 100000; i++) {
                bos.write(buffer);
            }
            bos.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("File was written with BufferedOutputStream class.");
    }

    public void writeFileByFileWriter() {
        String fileName = "D://Studies/Java/InputOutput/fileWriter.txt";

        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            for (int i = 0; i < 100000; i++) {
                fileWriter.write(text);
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("File was written with FileWriter class.");
    }

    public void writeFileWithBufferedWriter() {
        String fileName = "D://Studies/Java/InputOutput/bufferedWriterFile.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false))) {
            for (int i = 0; i < 100000; i++) {
                bufferedWriter.write(text);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("File was written with BufferedWriter class.");
    }

}
