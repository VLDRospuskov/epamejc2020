package homeworks.HW_7_bufferedReader;

import lombok.SneakyThrows;

import java.io.*;

public class MyIOSpeedCheck {

    private File sourceFile = new File("sourceFile.txt");
    private File destinationFile = new File("destinationFile.txt");

    public void run() {
        long executionTime = checkExecutionTimeNotBuffered();
        System.out.println("Execution time without buffer - " + executionTime + " ms");

        long executionTimeBuffered = checkExecutionTimeBuffered();
        System.out.println("Execution time with buffer - " + executionTimeBuffered + " ms");
    }

    public long checkExecutionTimeBuffered() {
        long startTimeBuffered = System.currentTimeMillis();

        writeFileBuffered();
        readAndWriteNewFileBuffered();

        long endTimeBuffered = System.currentTimeMillis();
        return endTimeBuffered - startTimeBuffered;
    }

    public long checkExecutionTimeNotBuffered() {
        long startTime = System.currentTimeMillis();

        writeFile();
        readAndWriteNewFile();

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    @SneakyThrows
    private void writeFile() {
        try (FileWriter fileWriter = new FileWriter(sourceFile)) {
            for (int i = 0; i < 1000000; i++) {
                fileWriter.write("Hello there, here is some text " + i + " ");
            }
        }
    }

    @SneakyThrows
    private void readAndWriteNewFile() {
        try (FileReader fileReader = new FileReader(sourceFile);
             FileWriter fileWriter = new FileWriter(destinationFile)) {
            int n;
            while ((n = fileReader.read()) != -1) {
                fileWriter.write((char) n);
            }
        }
    }

    @SneakyThrows
    private void writeFileBuffered() {
        try (BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(sourceFile))) {
            for (int i = 0; i < 1000000; i++) {
                bufferedFileWriter.write("Hello there, here is some text " + i + " ");
            }
        }
    }

    @SneakyThrows
    private void readAndWriteNewFileBuffered() {
        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(destinationFile))) {
            String str;
            while ((str = bufferedFileReader.readLine()) != null) {
                bufferedFileWriter.write(str);
            }
        }
    }

}
