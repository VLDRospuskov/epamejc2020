package homeworks.java.java8.part1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int subjects = 15;
        List<Integer> score = new ArrayList<>();
        score.add(85);
        score.add(75);
        score.add(34);
        score.add(98);
        score.add(14);
        score.add(8);
        score.add(57);
        score.add(43);
        score.add(22);
        score.add(76);
        score.add(55);
        score.add(65);
        score.add(87);
        score.add(63);
        score.add(45);
        score.add(95);

        Student<Integer> student = new Student<>(score, subjects, 3, "Vladimir", "Z7431");

        Integer averageScore =
                student.getAverageScore(
                        student::getScore,
                        student::getNumOfSubjects,
                        (sc, su) -> sc.stream()
                                .mapToInt(Integer::intValue)
                                .sum() / su
                );

        String output = student.getInfo(() -> student, (st) ->
                String.format("Student %1$s, group - %2$s, year %3$d, average score - %4$d",
                        st.getName(), st.getGroup(), st.getYear(), averageScore));

        System.out.println(output);

    }

}
