package homeworks.java.seabattle;

import homeworks.java.seabattle.data.Cell;
import homeworks.java.seabattle.resources.Settings;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Main {

@SneakyThrows
    public static void main(String[] args) {

//        Settings settings = new Settings();
//        Properties properties = settings.getProperties();
//        Iterator iterator = properties.entrySet().iterator();
//
//        while(iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//            System.out.println(entry.getKey() + " -- " + entry.getValue());
//        }

        FileWriter fileWriter = new FileWriter("com//epamejc//lessons//srs//main//homeworks//" +
                "java//seabattle//resources//prefs.config");
        fileWriter.write("asdfasdf");
        fileWriter.close();


        Cell cell = new Cell(1, 1);
        cell.setOccupied(true);
        cell.setShootable(true);

        System.out.println(cell);

    }

}
