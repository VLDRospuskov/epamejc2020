package Homeworks.HW7;


import java.io.*;

public class WithInputStream {

    InputStream inputStream = null;
    OutputStream outputStream = null;

    public void run() {
        try {
            inputStream = new FileInputStream(getClass().getClassLoader().getResource("lorem.txt").getFile());
            outputStream = new FileOutputStream(getClass().getClassLoader().getResource("out.txt").getFile());
            byte[] buffer = new byte[1024];
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
