package homeworks.HW_8_Java8.functionalInterfaces;

public class Main {

    public static void main(String[] args) {
        int random100 = Calculator.getRandomInt(() -> (int) (Math.random() * 100));
        System.out.println(random100);


    }

}
