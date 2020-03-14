package Home_works.HW_8;

public class Main {

    public static void main(String[] args) {
        Kitty kitty = new Kitty("Mura");

        FunctionalInterface<String, Integer, String> myFunInterface =
                (s1, s2) -> (int) (1 * s1.hashCode() + s2.hashCode() / 6);
        MySupplier<String> mySupp = () -> "Kate";
        kitty.daysOfHappyLifeTogether(myFunInterface, mySupp);
        System.out.println(kitty);


    }
}


