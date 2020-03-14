package Home_works.HW_7;

import java.io.*;

public class Writer {
    private static String text = "Test massage!";

    public void writeByBytes() {
        String fileName = "fileOutPutStream.txt";

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] buffer = text.getBytes();

            for (int i = 0; i < 100000; i++) {
                fos.write(buffer);
            }
            fos.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("File was written with FileOutputStream");
    }

    public void writeWithBuffer() {
        String fileName = "bufferOutPutStream.txt";

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName))) {
            byte[] buffer = text.getBytes();
            for (int i = 0; i < 100000; i++) {
                bos.write(buffer);
            }
            bos.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("File was written with BufferedOutputStream");
    }

    public void writeFileByFileWriter() {
        String fileName = "fileWriter.txt";

        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            for (int i = 0; i < 100000; i++) {
                fileWriter.write(text);
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("File was written with FileWriter");
    }

    public void writeFileWithBufferedWriter() {
        String fileName = "bufferedWriterFile.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false))) {
            for (int i = 0; i < 100000; i++) {
                bufferedWriter.write(text);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("File was written with BufferedWriter");
    }
}
