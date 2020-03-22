package main.homeworks.hw7;

public class Main {

    public static void main(String[] args) {
        FileWriterTextGenerator.generateText("main/homeworks/hw7/files/readfrom.txt");

        Reader reader = new Reader();
        long startTimeReader = System.currentTimeMillis();
        reader.readFile("main/homeworks/hw7/files/readfrom.txt");
        reader.writeIntoFile("main/homeworks/hw7/files/writeinto.txt");
        System.out.println("Done, time has passed " + (System.currentTimeMillis()- startTimeReader));

        BuffReader buffReader = new BuffReader();
        long startTimeBufferedReader = System.currentTimeMillis();
        buffReader.readFile("main/homeworks/hw7/files/readfrom.txt");
        buffReader.writeIntoFile("main/homeworks/hw7/files/writeinto.txt");
        System.out.println("Done for br, time has passed " + (System.currentTimeMillis()- startTimeBufferedReader));
    }
}
