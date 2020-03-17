package homeworks.homework8.functional_interfaces;

public class HeroAttack {

    public void execute() {
        Hero<Float> heroDva = new Hero<>("D.Va",
                                         "BlowUpAll",
                                         "MakeDamge",
                                         10.532465f);

        while (!(heroDva.isUltimateIsReady())) {
            heroDva.useAbility();
        }

        Float damageMade = heroDva.useUltimate(heroDva::getDamageDone,
                heroDva::getDamageCoefficient,
                (number, number2) -> number.intValue() * number2.floatValue());

        System.out.println("Hero: " + heroDva.getName() + "\nUsed ultimate: " + heroDva.getUltimate());
        System.out.println("And made: " + damageMade + " damage");
    }

}
