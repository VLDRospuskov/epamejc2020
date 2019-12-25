package homeworks.lesson2.immutableClass;

public class Main {
    public static void main(String[] args) {
        WordNotSparrow word = new WordNotSparrow("shit", "Mom");
        System.out.println(word.getPerson() + " said " + word.getWord());
        System.out.println("Now " + word.getPerson() + " wants to change it!");

        try {
            //word.word = "Nice!"; Can't do!
        } catch (Exception e) {
            System.out.println("Seems not!");
        } finally {
            System.out.println("Was " + word.getPerson() + " successful? The word is still " + word.getWord());
        }
    }
}
