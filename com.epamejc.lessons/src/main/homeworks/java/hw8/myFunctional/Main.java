package homeworks.java.hw8.myFunctional;

public class Main {

    public static void main(String[] args) {

        Employee<Double> alina = new Employee(7.5, 3507.254, 0.13, false);

        int alinasSalary = alina.resultActualSalary(() -> alina.getSalary(), () -> alina.getFees(),
                (num1, num2) -> (int) Math.round(num1.doubleValue() * (1 - num2.doubleValue())));

        System.out.format("Salary after paying fees %d\n", alinasSalary);

        int alinasSalaryWithBonuses = alina.resultActualSalaryWithBonuses(() -> alina.isDoesSmoke(), () -> alinasSalary,
                (bool, num) -> {
                    if (bool == false) {
                        return num.intValue() + 100;
                    } else {
                        return num.intValue() - 50;
                    }
                });

        System.out.format("Salary after adding bonuses %d\n", alinasSalaryWithBonuses);
    }
}
