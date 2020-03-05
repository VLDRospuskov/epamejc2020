package homework8.task1;


public class Java8Task1Main<T> {

    public static void main(String[] args) {

        Bicycle<Boolean> bicycle = new Bicycle<>(24, 124000.500);

        boolean shouldIBuyBike = bicycle.buyBike(
                bicycle::getNumberOfSpeeds,
                bicycle::getPrice,
                (numberOfSpeeds, price) -> (int) numberOfSpeeds * (double) price < 1_000_000);

        System.out.println(shouldIBuyBike);
    }
}
