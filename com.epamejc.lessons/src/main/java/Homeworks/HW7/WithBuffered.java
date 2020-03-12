package Homeworks.HW7;

import java.io.*;

public class WithBuffered {

    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    public void run() {
        try {
            FileReader fileReader = new FileReader("lorem.txt");
            FileWriter fileWriter = new FileWriter("outBuffered.txt");

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null && bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
