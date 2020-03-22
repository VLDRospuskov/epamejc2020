package homeworks.java.Java8.part1;

import homeworks.java.java8.part1.Student;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {

    private static Student<Integer> student;

    @BeforeClass
    public static void setup() {

        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            score.add(i);
        }

        int subjects = score.size();
        student = new Student<>(score, subjects, 3, "Vlad", "Z7431");

    }

    @Test
    public void testAverageScore() {

        Integer expected = 9;

        Integer actual =
                student.getAverageScore(
                        student::getScore,
                        student::getNumOfSubjects,
                        (sc, su) -> sc.stream()
                                .mapToInt(Integer::intValue)
                                .sum() / su
                );

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetInfo() {

        String expected = "Student Vlad, group - Z7431, year 3";

        String actual = student.getInfo(() -> student, (st) ->
                String.format("Student %1$s, group - %2$s, year %3$d",
                        st.getName(), st.getGroup(), st.getYear()));

        Assert.assertEquals(expected, actual);

    }
}
