package homeworks.homework7;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File fileToCopy = new File("com.epamejc.lessons/src/main/resources/types of bonfires.txt");
        File fileToSave = new File("com.epamejc.lessons/src/main/resources/types of bonfires copy.txt");
        File fileToBuff = new File("com.epamejc.lessons/src/main/resources/types of bonfires bufferedCopy.txt");

        long startFC = System.currentTimeMillis();

        FileCopier copier = new FileCopier();
        copier.copyFile(fileToCopy, fileToSave);

        long endFC = System.currentTimeMillis();
        System.out.println("File Reader time: " + (endFC - startFC) + " ms");

        FileCopierWithBuffered bufferedCopier = new FileCopierWithBuffered();
        bufferedCopier.copyFile(fileToCopy, fileToBuff);

        long endFCB = System.currentTimeMillis();
        System.out.println("File Reader with Buffered time: " + (endFCB - endFC) + " ms");
    }

}
