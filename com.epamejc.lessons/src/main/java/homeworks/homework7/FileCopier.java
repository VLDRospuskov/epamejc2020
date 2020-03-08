package homeworks.homework7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopier implements Сopyable{

    @Override
    public void copyFile(File fileToCopy, File fileToSave) {
        try {
            FileReader reader = new FileReader(fileToCopy);
            FileWriter writer = new FileWriter(fileToSave);

            while (reader.ready()) {
                writer.write(reader.read());
            }

            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
