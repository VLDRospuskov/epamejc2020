package homeworks.homework7;

public class Main {

    public static void main(String[] args) {

        Buffered buffered = new Buffered();
        NonBuffered nonBuffered = new NonBuffered();
        BufferedLine bufferedLine = new BufferedLine();

        System.out.printf("BufferedLine time: %d nanoseconds\nBuffered time:     %d nanoseconds\nNonBuffered time:  %d nanoseconds",
                           bufferedLine.measureTime(), buffered.measureTime(), nonBuffered.measureTime());
    }
}
