package homeworks.homework4;

public class Application {
    public static void main(String[] args) {

        StringChanger stringChanger = new StringChanger();
        StringGenerator generator = new StringGenerator(stringChanger);
        generator.run();
    }

}
