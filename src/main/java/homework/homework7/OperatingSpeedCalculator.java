package homework.homework7;

import java.io.*;

public class OperatingSpeedCalculator {

    private Timer timer = new Timer();

    public long measureTimerSpeed() {
        timer.start();
        timer.stop();
        return timer.getLastDuration();
    }

    public long measureFileReaderWriterSpeed() {
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

    public long measureBufferedReaderWriterSpeed() {
        try (Reader bufferedReader = new BufferedReader(new FileReader("source.txt"));
             Writer bufferedWriter = new BufferedWriter(new FileWriter("target2.txt"))) {

            timer.start();

            char[] data = new char[1024];
            int charCounts = bufferedReader.read(data, 0, data.length);
            while (charCounts != -1) {
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
