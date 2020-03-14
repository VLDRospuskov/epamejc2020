package homeworks.java.java8.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    /**
     * This is the java8 educational program.
     * Program uses an own functional interfaces {@link MyFunction}, {@link MyBiFunction} and {@link MySupplier}.
     * There is a usage of them in main class.
     *
     * @author Vladimir Ivanov
     */
    public static void main(String[] args) {

        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            score.add(new Random().nextInt(100));
        }

        int subjects = score.size();

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
