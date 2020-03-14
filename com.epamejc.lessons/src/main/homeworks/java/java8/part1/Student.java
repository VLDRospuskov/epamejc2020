package homeworks.java.java8.part1;

import lombok.Data;

import java.util.List;

@Data
public class Student<S> {

    private String name;
    private String group;
    private List<S> score;
    private S numOfSubjects;
    private S year;

    public Student(List<S> score, S numOfSubjects, S year, String name, String group) {

        this.name = name;
        this.group = group;
        this.score = score;
        this.numOfSubjects = numOfSubjects;
        this.year = year;

    }

    public <R> R getAverageScore(MySupplier<? extends List<S>> score,
                                 MySupplier<? extends S> disciplines,
                                 MyBiFunction<? super List<S>, ? super S, R> biFunction) {

        return biFunction.apply(score.get(), disciplines.get());

    }

    public String getInfo(MySupplier<? extends Student<S>> person,
                          MyFunction<? super Student<S>, String> function) {

        return function.apply(person.get());

    }

}