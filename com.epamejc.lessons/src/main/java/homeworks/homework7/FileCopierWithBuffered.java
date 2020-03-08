package homeworks.homework7;

import java.io.*;

public class FileCopierWithBuffered implements Сopyable {

    @Override
    public void copyFile(File fileToCopy, File fileToSave) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToCopy));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave));

            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
