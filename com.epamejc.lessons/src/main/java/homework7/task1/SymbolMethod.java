package homework7.task1;

import java.io.*;
import java.util.Date;

class SymbolMethod {

    void start() {
        Date startDate = new Date();
        try {
            BufferedReader fileRead = new BufferedReader(new InputStreamReader(new FileInputStream(
                    "./com.epamejc.lessons/src/main/resources/Source.txt"), "cp1251"));
            BufferedWriter fileWrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    "./com.epamejc.lessons/src/main/resources/SymbolMethodDestination.txt"), "cp1251"));

            String line;
            while ((line = fileRead.readLine()) != null) {
                fileWrite.write(line);
            }
            fileRead.close();
            fileWrite.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }

        Date finishDate = new Date();

        System.out.println("Lead time of SymbolMethod - " + (finishDate.getTime() - startDate.getTime()));
    }
}
