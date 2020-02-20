package homeworks.java.files;

public class TimeComparator {

    private String sourceFilePath = "com.epamejc.lessons/resources/text.txt";


    public void run() {

        FileManager fileManager = new FileManager();
        BufferedFileManager bufferedFileManager = new BufferedFileManager();

        long unBufferedTime = measureRunTime("com.epamejc.lessons/resources/resultUnbuffered.txt", fileManager);
        long BufferedTime = measureRunTime("com.epamejc.lessons/resources/resultBuffered.txt", bufferedFileManager);

        System.out.println("unBuffered -  " + unBufferedTime / 1000000);
        System.out.println("Buffered -  " + BufferedTime / 1000000);

    }

    /**
     * @param outputFilePath the path to a new file to be created
     * @param fileManager    {@link homeworks.java.files.FileManager} or {@link homeworks.java.files.BufferedFileManager}
     *                       instance.
     * @return long run time in milliseconds
     */
    private long measureRunTime(String outputFilePath, FileManager fileManager) {

        long startTime = System.nanoTime();
        String text2 = fileManager.readFile(sourceFilePath);
        fileManager.writeFile(text2, outputFilePath);
        return System.nanoTime() - startTime;

    }

}
