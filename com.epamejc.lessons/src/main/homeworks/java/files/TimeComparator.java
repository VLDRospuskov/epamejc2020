package homeworks.java.files;

public class TimeComparator {

    public void run() {

        FileManager fileManager = new FileManager();
        BufferedFileManager bufferedFileManager = new BufferedFileManager();

        long startTime = System.nanoTime();
        String text = fileManager.readFile("com.epamejc.lessons/resources/text.txt");
        fileManager.writeFile(text, "com.epamejc.lessons/resources/result1.txt");
        long unBufferedTime = System.nanoTime() - startTime;

        long startTime1 = System.nanoTime();
        String text2 = bufferedFileManager.readFile("com.epamejc.lessons/resources/text.txt");
        bufferedFileManager.writeFile(text2, "com.epamejc.lessons/resources/result2.txt");
        long BufferedTime = System.nanoTime() - startTime1;

        System.out.println("unBuffered -  " + unBufferedTime / 1000000);
        System.out.println("Buffered -  " + BufferedTime / 1000000);

    }

}
