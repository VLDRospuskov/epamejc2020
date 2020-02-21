package Homeworks.HW7;

import java.io.*;

public class WithBuffered {

    public void run() {
        try {
            FileReader fileReader = new FileReader("lorem.txt");
            FileWriter fileWriter = new FileWriter("outBuffered.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
            }
            bufferedWriter.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
