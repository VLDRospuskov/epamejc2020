package Homeworks.HW7;

import java.io.*;

public class WithBuffered {

    public void run() {
        File file = new File(getClass().getClassLoader().getResource("lorem.txt").getFile());
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
