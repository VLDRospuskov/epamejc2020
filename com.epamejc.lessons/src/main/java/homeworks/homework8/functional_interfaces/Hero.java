package homeworks.homework8.functional_interfaces;

import homeworks.homework8.functional_interfaces.interfaces.MyBiFunction;
import homeworks.homework8.functional_interfaces.interfaces.MySupplier;

import java.util.Random;


public class Hero<T extends Number> {

    private String name;
    private String ultimate;
    private String ability;
    private float ultimateCharged;
    private int damageDone;
    private T damageCoefficient;
    private boolean ultimateIsReady;

    public Hero(String name, String ultimate, String ability, T damageCoefficient) {
        this.name = name;
        this.ultimate = ultimate;
        this.ability = ability;
        this.ultimateCharged = 0.0f;
        this.damageDone = 0;
        this.damageCoefficient = damageCoefficient;
        this.ultimateIsReady = false;
    }

    public String getName() {
        return name;
    }

    public String getUltimate() {
        return ultimate;
    }

    public String getAbility() {
        return ability;
    }

    public Integer getDamageDone() {
        return damageDone;
    }

    public T getDamageCoefficient() {
        return damageCoefficient;
    }

    public boolean isUltimateIsReady() {
        return ultimateIsReady;
    }

    public void useAbility() {
        Random rnd = new Random();

        int damage = rnd.nextInt(100) + 1;
        damageDone += damage;
        ultimateCharged += 0.1f * damage;

        if (ultimateCharged >= 100.0) {
            ultimateIsReady = true;
        }
    }

    public  <R> R useUltimate(MySupplier<? extends Number> damageDone,
                              MySupplier<? extends Number> damageCoefficient,
                              MyBiFunction<? super Number, ? super Number, ? extends R> damageByUlt) {

        Number damage = damageDone.get();
        Number coefficient = damageCoefficient.get();
        return damageByUlt.apply(damage, coefficient);
    }

}
