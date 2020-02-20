package homework7.task1;

import java.io.*;
import java.util.Date;

class ByteMethod {

    void start() {
        Date startDate = new Date();
        try {
            FileInputStream fileInput = new FileInputStream(
                    "./com.epamejc.lessons/src/main/resources/Source.txt");
            FileOutputStream fileOutput = new FileOutputStream(
                    "./com.epamejc.lessons/src/main/resources/ByteMethodDestination.txt");

            int nextByte;
            while ((nextByte = fileInput.read()) != -1) {
                fileOutput.write(nextByte);
            }
            fileInput.close();
            fileOutput.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }

        Date finishDate = new Date();

        System.out.println("Lead time of ByteMethod - " + (finishDate.getTime() - startDate.getTime()));
    }
}
