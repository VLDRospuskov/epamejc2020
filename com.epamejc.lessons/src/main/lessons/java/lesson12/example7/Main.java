package lessons.java.lesson12.example7;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        byte[] bytesToWrite = { 1, 2, 3 };
        byte[] bytesReaded = new byte[10];
        String fileName = "test.txt";
        FileOutputStream outFile = null;
        FileInputStream inFile = null;

        outFile = new FileOutputStream(fileName);
        System.out.println("Файл открыт для записи");
        outFile.write(bytesToWrite);
        System.out.println("Записано: "
                + bytesToWrite.length + " байт");
        outFile.close();
        System.out.println("Выходной поток закрыт");

        inFile = new FileInputStream(fileName);
        System.out.println("Файл открыт для чтения");
        int bytesAvailable = inFile.available();
        System.out.println("Готово к считыванию: "
                + bytesAvailable + " байт");
        int count = inFile.read(bytesReaded, 0, bytesAvailable);
        System.out.println("Считано: " + count + " байт");
        inFile.close();
        System.out.println("Входной поток закрыт");


    }
}
