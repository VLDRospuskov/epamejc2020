package homeworks.hw7;

public class Main {

    public static void main(String[] args) {
        FileWriterTextGenerator.generateText("src/homeworks/hw7/files/readfrom.txt");

        Reader reader = new Reader();
        long startTimeReader = System.currentTimeMillis();
        reader.readFile("src/homeworks/hw7/files/readfrom.txt");
        reader.writeIntoFile("src/homeworks/hw7/files/writeinto.txt");
        System.out.println("Done, time has passed " + (System.currentTimeMillis()- startTimeReader));

        BuffReader buffReader = new BuffReader();
        long startTimeBufferedReader = System.currentTimeMillis();
        buffReader.readFile("src/homeworks/hw7/files/readfrom.txt");
        buffReader.writeIntoFile("src/homeworks/hw7/files/writeinto.txt");
        System.out.println("Done for br, time has passed " + (System.currentTimeMillis()- startTimeBufferedReader));
    }
}
