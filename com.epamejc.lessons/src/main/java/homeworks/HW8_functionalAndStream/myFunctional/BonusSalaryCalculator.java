package homeworks.HW8_functionalAndStream.myFunctional;

public class BonusSalaryCalculator {

    private long baseSalary = 30_000_000;

    public void calculate() {
        Statistics<Integer> lewisHamilton = new Statistics(5, 11, true);

        long raceBonuses = lewisHamilton.calculateBonuses(lewisHamilton::getPolesNumber,
                lewisHamilton::getWinsNumber,
                (number1, number2) -> (long) (number1.intValue() * 250_000 + number2.intValue() * 500_000));

        long raceBonusesWithTitle = lewisHamilton.calculateTitleBonus(lewisHamilton::isTitleWon, () -> raceBonuses,
                (boolean1, number2) -> {
                    if (boolean1) {
                        return (long) number2.intValue() + 5_000_000;
                    } else {
                        return (long) number2.intValue();
                    }
                });

        long totalSalaryWithBonuses = lewisHamilton.calculateBonuses(() -> raceBonusesWithTitle, () -> this.baseSalary,
                (number1, number2) -> (number1.longValue() + number2.longValue()));

        System.out.println("SalaryStatistics: \nBonuses: " + raceBonuses + "\nTotalBonuses: "
                + raceBonusesWithTitle + "\nTotalSalary: " + totalSalaryWithBonuses);
    }
}
