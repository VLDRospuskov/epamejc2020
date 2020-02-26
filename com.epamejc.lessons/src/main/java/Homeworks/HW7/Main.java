package Homeworks.HW7;

public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        WithFileReaderWriter withFileReaderWriter = new WithFileReaderWriter();
        withFileReaderWriter.run(); // 3s

        long time = System.currentTimeMillis();
        System.out.println((time - start) + " ms");

        WithBuffered withBuffered = new WithBuffered();
        withBuffered.run(); // 0s

        System.out.println((System.currentTimeMillis() - time) + " ms");
    }
}
