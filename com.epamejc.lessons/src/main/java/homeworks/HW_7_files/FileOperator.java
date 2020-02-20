package homeworks.HW_7_files;

import java.io.File;

public class FileOperator {

    private String sourceFilePath = "com.epamejc.lessons/files/book.txt";
    private String unbufferedWriterFilePath = "com.epamejc.lessons/files/unbufferedWrittenFile.txt";
    private String bufferedWriterFilePath = "com.epamejc.lessons/files/bufferedWrittenFile.txt";

    public void run() {

        FileStream fileStream = new FileStream();
        BufferedFileStream bufferedFileStream = new BufferedFileStream();

        long timeWithoutBuffer = countReadWriteTime(unbufferedWriterFilePath, fileStream);
        long timeWithBuffer = countReadWriteTime(bufferedWriterFilePath, bufferedFileStream);

        printFileLength(sourceFilePath);
        System.out.println("File read and write time without buffer is: " + timeWithoutBuffer + " millisecond");
        System.out.println("File read and write time with buffer is: " + timeWithBuffer + " millisecond");
    }

    /**
     * Counting file read and write time
     *
     * @param destinationFilePath path to the new file that is being written
     * @param fileStream          FileStream or BufferedFileStream instance.
     * @return counted time in milliseconds
     */
    private long countReadWriteTime(String destinationFilePath, FileStream fileStream) {
        long startTime = System.currentTimeMillis();
        String fileContent = fileStream.readFile(sourceFilePath);
        fileStream.writeFile(fileContent, destinationFilePath);
        return System.currentTimeMillis() - startTime;
    }

    /**
     * Print file length in bytes
     *
     * @param filePath path to the file
     */
    private void printFileLength(String filePath) {
        try {
            File file = new File(filePath);
            System.out.println("File size is: " + file.length() + " bytes");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
