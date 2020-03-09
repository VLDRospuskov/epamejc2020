package homeworks.hw8.functionalInterfaces;

public class Main {

    public static void main(String[] args) {

        Employee<Double> someGuy = new Employee("The Guy", 29, 1200, 5,
                13);

        Double someGuysSalary = someGuy.salaryWithYearsBasedBonus(() -> someGuy.getSalary(),
                () -> someGuy.getYearsInCompany(),
                (par1, par2) -> (Double) (par1.doubleValue() +
                        par2.doubleValue() * 0.345));

        System.out.println("Smth happened, here is some guy's salary with his years bonuses: " + someGuysSalary);

        Double someGuysSalaryWithMoreBonuses = someGuy.salaryWithAdditionalBonuses(() -> someGuy.getAge(),
                                                                                () -> someGuy.getNumberOfAchievements(),
                                                                                (par1, par2) -> (Double) (someGuysSalary
                                                                                        + par1.doubleValue()
                                                                                        + par2.doubleValue() * 500));

        System.out.println("Here is guy's salary: " + someGuysSalaryWithMoreBonuses);
    }
}
