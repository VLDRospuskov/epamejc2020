package homework.hw7;

import java.io.*;

public class CompareReadingTime {
    public static void main(String[] args) {
        writeIntoFile("source.txt");

        long startTime = System.currentTimeMillis();
        writeIntoAnotherFile("source.txt", "destination.txt");
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");

        long startTimeBuff = System.currentTimeMillis();
        writeIntoAnotherFileBuff("source.txt", "destination.txt");
        long endTimeBuff = System.currentTimeMillis();
        System.out.println("Total execution time buffered: " + (endTimeBuff-startTimeBuff) + "ms");

    }

    private static void writeIntoFile(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (int i = 0; i < 1024*1024+100; i++) {
                fileWriter.write("H");
            }
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            System.err.println("There is no such file exists " + fileName);
        } catch (IOException e) {
            System.err.println("Something went wrong " + fileName);
        }
    }


    private static void writeIntoAnotherFile (String source, String destination){
        try (FileReader fileReader = new FileReader(source); FileWriter fileWriter = new FileWriter(destination)) {
            char[] chars = new char[1024];
            int charRead = fileReader.read(chars, 0, 1024);
            while (charRead > 0){
                fileWriter.write(chars, 0, charRead);
                charRead = fileReader.read(chars, 0, 1024);
            }
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            System.err.println("There is no such file exists " + source);
        } catch (IOException e) {
            System.err.println("Something went wrong " + source);
        }
    }

    private static void writeIntoAnotherFileBuff (String source, String destination){
        try (BufferedReader fileReader = new BufferedReader(new FileReader(source)); FileWriter fileWriter = new FileWriter(destination)) {
            char[] chars = new char[1024];
            int charRead = fileReader.read(chars, 0, 1024);
            while (charRead > 0){
                fileWriter.write(chars, 0, charRead);
                charRead = fileReader.read(chars, 0, 1024);
            }
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            System.err.println("There is no such file exists " + source);
        } catch (IOException e) {
            System.err.println("Something went wrong " + source);
        }
    }
}

