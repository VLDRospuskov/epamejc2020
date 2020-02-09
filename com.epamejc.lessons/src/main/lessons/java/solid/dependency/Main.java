package lessons.java.solid.dependency;

public class Main {

    public static void main(String[] args) {
        Init init = new Init(new AnimalOperations(), new AnimalOperationsWithLog());
        init.start();
    }

}
