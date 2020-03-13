package homework.homework7;

public class Main {
    public static void main(String[] args) {
        OperatingSpeedCalculator calculator = new OperatingSpeedCalculator();

        System.out.println("Timer speed " + calculator.measureTimerSpeed());
        System.out.println("FileReader and FileWriter speed " + calculator.measureFileReaderWriterSpeed());
        System.out.println("BufferedReader and BufferedWriter speed " + calculator.measureBufferedReaderWriterSpeed());
    }
}
