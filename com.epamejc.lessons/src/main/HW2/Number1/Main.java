package main.HW2.Number1;

/**immutable class
    To create an immutable class in java, you have to do following steps.

    Declare the class as final so it can’t be extended.
    Make all fields private so that direct access is not allowed.
    Don’t provide setter methods for variables
    Make all mutable fields final so that it’s value can be assigned only once.
    Initialize all the fields via a constructor performing deep copy.
    Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        int num1 = Integer.parseInt(reader("\"Write the age of the pet: \""));

        Age age = new Age();

        age.setYear(num1);

        ImmutableClass pet = new ImmutableClass(1, reader("Write the name of the pet: ") , age);

        System.out.println(pet.getName() + " age year before modification = " + pet.getAge().getYear());

        int num2 = Integer.parseInt(reader("Change the age of the pet: "));
        age.setYear(num2);

        System.out.println(pet.getName() + " age year after modification = " + pet.getAge().getYear());

    }


    public static String reader(String s){
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
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
