package homeworks.hw8.functionalInterfaces;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee<R> {

    private String name;
    private Integer age;
    private Integer salary;
    private Integer yearsInCompany;
    private Integer numberOfAchievements;

    public <R> R salaryWithYearsBasedBonus(Supplier<? extends Number> salary,
                                           Supplier<? extends Number> years,
                                           BiFunction<? super Number, ? super Number, ? extends R> function) {
        R r = function.apply(salary.get(), years.get());
        return r;
    }

    public <R> R salaryWithAdditionalBonuses(Supplier<? extends Number> age,
                                             Supplier<Integer> achievements,
                                             BiFunction<? super Number, Integer, ? extends R> function) {
        R r = function.apply(age.get(), achievements.get());
        return r;
    }

}
