package homeworks.java.hw7;

import java.io.*;
import java.util.Arrays;

public class FilesReaderAndRewriter {

    public void readAndRewriteByBytes() {
        String fileName = "D://Studies/Java/InputOutput/fileoutputstreamtext.txt";
        String newFileName = "D://Studies/Java/InputOutput/fileoutputstreamtext.txt";

        try (FileInputStream fis = new FileInputStream(fileName);
             FileOutputStream fos = new FileOutputStream
                     (newFileName)) {
            System.out.format("File size is %d bytes\n", fis.available());
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, buffer.length);
            fos.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Reading and rewriting are completed by using an FileInput/OutputStream classes.");
    }

    public void readAndRewriteByBuffer() {
        String fileName = "D://Studies/Java/InputOutput/bufferedoutputstreamtext.txt";
        String newFileName = "D://Studies/Java/InputOutput/bufferedoutputstreamtext_new.txt";

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFileName))) {
            System.out.format("File size is %d bytes\n", bis.available());
            byte[] buffer = new byte[bis.available()];
            int c;
            while ((c = bis.read(buffer)) > 0) {
                bos.write(buffer);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Reading and rewriting are completed by using an BufferedInput/OutputStream classes.");
    }

    public void readAndRewriteByFileReaderWriter() {
        String fileName = "D://Studies/Java/InputOutput/fileWriter.txt";
        String newFileName = "D://Studies/Java/InputOutput/fileWriter_new.txt";
        try (FileReader fileReader = new FileReader(fileName);
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
        System.out.println("Reading and rewriting are completed by using a FileReader/Writer classes.");
    }

    public void readAndRewriteByBufferedReaderWriter() {
        String fileName = "D://Studies/Java/InputOutput/bufferedWriterFile.txt";
        String newFileName = "D://Studies/Java/InputOutput/bufferedWriterFile_new.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
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
        System.out.println("Reading and rewriting are completed by using a BufferedReader/Writer classes.");
    }

}
