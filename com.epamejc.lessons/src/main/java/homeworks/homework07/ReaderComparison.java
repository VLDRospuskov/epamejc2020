package homeworks.homework07;

import lombok.SneakyThrows;

import java.io.*;

public class ReaderComparison {
    private final static int SIZE = 1000000;

    String inputFileName = "in.txt";
    String outputFileName = "out.txt";
    FileReader fileReader;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    char[] chars = new char[SIZE];

    @SneakyThrows
    public static void main(String[] args) {
        //fillInFile();

        ReaderComparison readerComparison = new ReaderComparison();

        long before;
        long after;

        before = System.nanoTime();
        readerComparison.readWithFileReader();
        after = System.nanoTime();
        long result1 = after - before;

        before = System.nanoTime();
        readerComparison.readWithBufferedReader();
        after = System.nanoTime();
        long result2 = after - before;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println((result2 < result1 ? "BufferedReader " : "FileReader ") + "is faster by " + Math.abs(result2 - result1));
    }

    @SneakyThrows
    public ReaderComparison() {
        fileReader = new FileReader(inputFileName);
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
        bufferedWriter = new BufferedWriter(new FileWriter(outputFileName));
    }

    @SneakyThrows
    private void readWithFileReader() {
        fileReader.read(chars);
    }

    @SneakyThrows
    private void readWithBufferedReader() {
        bufferedReader.read(chars);
    }

    @SneakyThrows
    private void copyText(Reader reader) {
        bufferedWriter.write(chars);
        bufferedWriter.flush();
    }

    @SneakyThrows
    private static void fillInFile() {
        char[] chars = {' ', 'k', 'I', 'm', 'o', 'a'};
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("in.txt"));
        for (int i = 0; i < SIZE; i++) {
            bufferedWriter.write(chars[(int) (Math.random() * 6)]);
        }
        bufferedWriter.flush();
    }

}
