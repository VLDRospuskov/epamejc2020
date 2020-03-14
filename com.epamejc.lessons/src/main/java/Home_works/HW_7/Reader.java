package Home_works.HW_7;

import java.io.*;
import java.util.Arrays;

public class Reader {
    public void readByBytes() {
        String fileNameToRead = "fileOutPutStream.txt";
        String newFileName = "fileOutPutStream_new.txt";

        try (FileInputStream fis = new FileInputStream(fileNameToRead);
             FileOutputStream fos = new FileOutputStream
                     (newFileName)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, buffer.length);
            fos.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Reading is completed with FileInput/OutputStream");
    }

    public void readByBuffer() {
        String fileNameToRead = "bufferOutPutStream.txt";
        String newFileName = "bufferOutPutStream_new.txt";

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileNameToRead));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFileName))) {
            byte[] buffer = new byte[bis.available()];
            int c;
            while ((c = bis.read(buffer)) > 0) {
                bos.write(buffer);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Reading is completed with BufferedInput/OutputStream");
    }

    public void readByFileReaderWriter() {
        String fileNameToRead = "fileWriter.txt";
        String newFileName = "fileWriter_new.txt";
        try (FileReader fileReader = new FileReader(fileNameToRead);
             FileWriter fileWriter = new FileWriter(newFileName)) {
            char[] buff = new char[1024];
            int c;
            while ((c = fileReader.read(buff)) > 0) {
                if (c < 1024) {
                    buff = Arrays.copyOf(buff, c);
                }
                fileWriter.write(buff);
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Reading is completed with FileReader/Writer");
    }

    public void readByBufferedReaderWriter() {
        String fileNameToRead = "bufferedWriterFile.txt";
        String newFileName = "bufferedWriterFile_new.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameToRead));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFileName))) {
            char[] buff = new char[1024];
            int c;
            while ((c = bufferedReader.read(buff)) > 0) {
                if (c < 1024) {
                    buff = Arrays.copyOf(buff, c);
                }
                bufferedWriter.write(buff);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Reading is completed with BufferedReader/Writer");
    }
}
