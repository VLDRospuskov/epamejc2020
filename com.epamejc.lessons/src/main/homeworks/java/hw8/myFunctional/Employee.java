package homeworks.java.hw8.myFunctional;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Employee<T> {

    private T experienceInYears;
    private T salary;
    private T fees;
    private boolean doesSmoke;

    public Employee(T experienceInYears, T salary, T fees, boolean doesSmoke) {
        this.experienceInYears = experienceInYears;
        this.salary = salary;
        this.fees = fees;
        this.doesSmoke = doesSmoke;
    }

    public T getExpirienceInYears(){
        return experienceInYears;
    }

    public T getSalary(){
        return salary;
    }

    public T getFees(){
        return fees;
    }

    public boolean isDoesSmoke(){
        return doesSmoke;
    }

    public <R> R resultActualSalary(MySupplier<? extends Number> supplier1,
                                    MySupplier<? extends Number> supplier2,
                                    MyFunction<? super Number, ? super Number, ? extends R> myFunction){
        Number num1 = supplier1.get();
        Number num2 = supplier2.get();
        R r = myFunction.apply(num1, num2);
        return r;
    }

    public <R> R resultActualSalaryWithBonuses(MySupplier<? extends Boolean> supplier1,
                                    MySupplier<? extends Number> supplier2,
                                    MyFunction<? super Boolean, ? super Number, ? extends R> myFunction){
        Boolean b = supplier1.get();
        Number num = supplier2.get();
        R r = myFunction.apply(b, num);
        return r;
    }

}
