package homework.homework4;

import java.io.*;

public class OperatingSpeedCalculator {

    private Timer timer = new Timer();

    public static void main(String[] args) {

        OperatingSpeedCalculator calculator = new OperatingSpeedCalculator();

        System.out.println("Timer speed " + calculator.measureTimerSpeed());
        System.out.println("FileReader and FileWriter speed " + calculator.measureFileReaderWriterSpeed());
        System.out.println("BufferedReader and BufferedWriter speed " + calculator.measureBufferedReaderWriterSpeed());
    }

    private long measureTimerSpeed() {
        timer.start();
        timer.stop();
        return timer.getLastDuration();
    }

    private long measureFileReaderWriterSpeed() {
        try (Reader fileReader = new FileReader("source.txt");
             Writer fileWriter = new FileWriter("target1.txt")) {

            timer.start();

            int data = fileReader.read();
            while (data != -1) {
                fileWriter.write(data);
                data = fileReader.read();
            }
            fileWriter.flush();

            timer.stop();
            return timer.getLastDuration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private long measureBufferedReaderWriterSpeed() {
        try (Reader bufferedReader = new BufferedReader(new FileReader("source.txt"));
             Writer bufferedWriter = new BufferedWriter(new FileWriter("target2.txt"))) {

            timer.start();

            char[] data = new char[1024];
            int charCounts = bufferedReader.read(data, 0, data.length);
            while(charCounts != -1) {
                bufferedWriter.write(data, 0, charCounts);
                charCounts = bufferedReader.read(data, 0, data.length);
            }
            bufferedWriter.flush();

            timer.stop();
            return timer.getLastDuration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
