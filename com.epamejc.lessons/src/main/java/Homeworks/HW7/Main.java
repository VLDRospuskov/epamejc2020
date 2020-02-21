package Homeworks.HW7;

import java.io.File;
import java.sql.Time;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        File directory = new File("./src/main/resources");
        System.out.println(directory.getAbsolutePath());
        File file = new File("./src/main/resources/lorem.txt");
        System.out.println(file.exists());
        /*
        long start = System.currentTimeMillis();

        //WithBuffered buffered = new WithBuffered();
        //buffered.run();
        WithInputStream inputStream = new WithInputStream();
        inputStream.run();

        System.out.println(System.currentTimeMillis() - start);*/
    }
}
