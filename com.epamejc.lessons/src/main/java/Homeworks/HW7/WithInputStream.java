package Homeworks.HW7;


import java.io.*;

public class WithInputStream {
    public void run() {
        try {
            InputStream inputStream = new FileInputStream(getClass().getClassLoader().getResource("lorem.txt").getFile());
            OutputStream outputStream = new FileOutputStream(getClass().getClassLoader().getResource("out.txt").getFile());
            byte[] buffer = new byte[1024];
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
