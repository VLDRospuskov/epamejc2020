package main.lessons.lesson03022020;

public class SuppressedEx {

    public static void main(String[] args) {

        try (JammedTurkeyCage t1 = new JammedTurkeyCage();
             JammedTurkeyCage t2 = new JammedTurkeyCage()) {
            System.out.println("Turkeys entered cages");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
            for (Throwable t: e.getSuppressed())
                System.out.println(t.getMessage());
        }
    }
}
