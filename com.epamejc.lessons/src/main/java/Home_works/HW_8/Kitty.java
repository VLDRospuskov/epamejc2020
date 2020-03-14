package Home_works.HW_8;

import lombok.Data;

@Data
public class Kitty {
    private String name;
    private int daysOfHappyLife;
    private String nameOfMaster;

    public Kitty(String name) {
        this.name = name;
    }

    public String daysOfHappyLifeTogether(FunctionalInterface<String, Integer, String> myFunInterface,
                                          MySupplier<String> mySupp) {
        nameOfMaster = mySupp.get();
        daysOfHappyLife = myFunInterface.apply(name, nameOfMaster);
        return nameOfMaster;
    }
}
