package homeworks.java.seabattle;

import homeworks.java.seabattle.data.Cell;
import homeworks.java.seabattle.data.Field;
import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Main {

@SneakyThrows
    public static void main(String[] args) {


    Field field = new Field();
    field.arrangeShipsRandom();
    System.out.println(field.toString());
//        Settings settings = new Settings();
//        Properties properties = settings.getProperties();
//        Iterator iterator = properties.entrySet().iterator();
//
//        while(iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//            System.out.println(entry.getKey() + " -- " + entry.getValue());
//        }

//        FileWriter fileWriter = new FileWriter("com.epamejc.lessons/rosources/prefs.config");
//        OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream("com.epamejc.lessons/src/main/homeworks/java/seabattle/resources/prefs.config"));
//        fileWriter.write("asdfasdf");
//        fileWriter.close();
//
//
//        Cell cell = new Cell(1, 1);
//        cell.setOccupied(true);
//        cell.setShootable(true);
//
//        System.out.println(cell);

    }

}
