package main.homeworks.hw2;

import java.util.HashSet;

public class StudentCreatorClass {

    private static HashSet<Integer> idTable = new HashSet<>();

    public static void setIdTable(int id) {
        idTable.add(id);
    }

    public static HashSet<Integer> getIdTable() {
        return idTable;
    }

    public void create(int id, String name, int day, int month, int year) {
        MutableAge firstStudent = new MutableAge();

        firstStudent.setDay(day);
        firstStudent.setMonth(month);
        firstStudent.setYear(year);
        ImmutableClassStudent student = new ImmutableClassStudent(id, name, firstStudent);

        System.out.println(String.format("You have created a new student.\nThe student's name is %s \nThe student id " +
                        "is %d \nThe student birthday is %d.%d.%d", student.getName(), student.getId(),
                student.getAge().getDay(), student.getAge().getMonth(), student.getAge().getYear()));
    }

}
