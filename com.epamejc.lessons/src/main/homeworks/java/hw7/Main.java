package homeworks.java.hw7;

public class Main {
    public static void main (String[] args) {
        SimpleFileCopy scopy = new SimpleFileCopy();
        scopy.run();
        BufferedFileCopy bcopy = new BufferedFileCopy();
        bcopy.run();
    }
}
