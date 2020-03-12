package homeworks.homework7;

import java.io.*;

public class ReaderComparison {
    
    private final static int SIZE = 100_000_000;
    private String sourceFile = "source.txt";
    private String outputFile = "output.txt";
    private char[] chars = new char[1000];
    
    public void compareTime() {
        fillFile(sourceFile);
        long startTime = System.currentTimeMillis();
        writeWithFileReader();
        long endTime = System.currentTimeMillis();
        System.out.println("FileReader time: " + (endTime - startTime) + "ms");
        
        long startTimeBuff = System.currentTimeMillis();
        writeWithBufferedReader();
        long endTimeBuff = System.currentTimeMillis();
        System.out.println("BufferedReader time: " + (endTimeBuff - startTimeBuff) + "ms");
        
    }
    
    private void fillFile(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (int i = 0; i < SIZE; i++) {
                fileWriter.write("Hello Mr.Anderson.");
            }
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            System.err.println("There is no such file exists " + fileName);
        } catch (IOException e) {
            System.err.println("Something went wrong " + fileName);
        }
    }
    
    private void writeWithFileReader() {
        
        try (FileReader fileReader = new FileReader(sourceFile);
             FileWriter fileWriter = new FileWriter(outputFile)) {
            int read = fileReader.read(chars, 0, chars.length);
            while (read > 0) {
                fileWriter.write(chars, 0, chars.length);
                read = fileReader.read(chars, 0, chars.length);
            }
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            System.err.println("There is no such file exists " + sourceFile);
        } catch (IOException e) {
            System.err.println("Something went wrong " + sourceFile);
        }
    }
    
    private void writeWithBufferedReader() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(sourceFile));
             FileWriter fileWriter = new FileWriter(outputFile)) {
            int read = fileReader.read(chars, 0, chars.length);
            while (read > 0) {
                fileWriter.write(chars, 0, chars.length);
                read = fileReader.read(chars, 0, chars.length);
            }
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            System.err.println("There is no such file exists " + sourceFile);
        } catch (IOException e) {
            System.err.println("Something went wrong " + sourceFile);
        }
    }
    
}
