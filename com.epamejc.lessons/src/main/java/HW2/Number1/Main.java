package HW2.Number1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        int num1 = Integer.parseInt(reader("\"Write the age of the pet: \""));

        Age age = new Age();

        age.setYear(num1);

        ImmutableClass pet = new ImmutableClass(1, reader("Write the name of the pet: "), age);

        System.out.println(pet.getName() + " age year before modification = " + pet.getAge().getYear());

        int num2 = Integer.parseInt(reader("Change the age of the pet: "));
        age.setYear(num2);

        System.out.println(pet.getName() + " age year after modification = " + pet.getAge().getYear());

    }


    public static String reader(String s) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String srt = null;
        try {
            System.out.println(s);
            srt = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return srt;
    }

}
