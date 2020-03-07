package main.homeworks.java.homework7;

public class RegularBufferedTiming {

    private String file = "book.out";

    public void run(String URL) {
        URLtoFileSaver urLtoFileSaver =  new URLtoFileSaver(URL);
        urLtoFileSaver.writeToFile();
        RegularBuffered rb = new RegularBuffered();
            long regularTime = getTime(rb);
            long bufferedTime = getBufferedTime(rb);
            System.out.println("Regular time: " + regularTime + " ms");
            System.out.println("Buffered time: " + bufferedTime + " ms");
    }

    private long getTime(RegularBuffered rb) {
        long start = System.currentTimeMillis();
        String text = rb.readFromFile(file);
        rb.writeToFile(text);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private long getBufferedTime(RegularBuffered rb) {
        long start = System.currentTimeMillis();
        String text = rb.BufferedReadFromFile(file);
        rb.BufferedWriteToFile(text);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
