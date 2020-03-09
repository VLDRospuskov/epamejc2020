package homeworks.HW_7_bufferedReader;

import lombok.SneakyThrows;

import java.io.*;

public class MyIOSpeedCheck {
    File sourceFile = new File("sourceFile.txt");
    File destinationFile = new File("destinationFile.txt");
    FileWriter fileWriter;
    BufferedWriter bufferedFileWriter;
    long executionTime;
    long executionTimeBuffered;

    @SneakyThrows
    public void run() {
        writeFile();
        readAndWriteNewFile();
        System.out.println("Время выполнения без буфера - " + executionTime + " миллисекунд");

        writeFileBuffered();
        readAndWriteNewFileBuffered();
        System.out.println("Время выполнения c буфером - " + executionTimeBuffered + " миллисекунд");
    }

    @SneakyThrows
    private void writeFile() {
        long startTime = System.currentTimeMillis();
        fileWriter = new FileWriter(sourceFile);
        for (int i = 0; i < 1000000; i++) {
            fileWriter.write("Hello there, here is some text " + i + " ");
        }
        fileWriter.flush();
        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
    }

    @SneakyThrows
    private void readAndWriteNewFile() {
        long startTime = System.currentTimeMillis();

        FileReader fileReader = new FileReader(sourceFile);
        fileWriter = new FileWriter(destinationFile);
        int n;
        while ((n = fileReader.read()) != -1) {
            fileWriter.write((char) n);
        }

        long endTime = System.currentTimeMillis();
        executionTime += endTime - startTime;

        fileWriter.close();
        fileReader.close();
    }

    @SneakyThrows
    private void writeFileBuffered() {
        long startTime = System.currentTimeMillis();

        bufferedFileWriter = new BufferedWriter(new FileWriter(sourceFile));
        for (int i = 0; i < 1000000; i++) {
            bufferedFileWriter.write("Hello there, here is some text " + i + " ");
        }
        bufferedFileWriter.flush();

        long endTime = System.currentTimeMillis();
        executionTimeBuffered = endTime - startTime;
    }

    @SneakyThrows
    private void readAndWriteNewFileBuffered() {
        long startTime = System.currentTimeMillis();

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(sourceFile));
        bufferedFileWriter = new BufferedWriter(new FileWriter(destinationFile));
        String str;
        while ((str = bufferedFileReader.readLine()) != null) {
            bufferedFileWriter.write(str);
        }
        bufferedFileReader.close();
        bufferedFileWriter.close();

        long endTime = System.currentTimeMillis();
        executionTimeBuffered += endTime - startTime;
    }

}
