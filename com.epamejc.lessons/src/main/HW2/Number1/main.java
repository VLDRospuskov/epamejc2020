package main.HW2.Number1;

/*immutable class
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

public class main {

    public static void main(String[] args) {
        // write your code here
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String age1 = null;
        try {
            System.out.println("Write the age of the pet: ");
            age1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int num1 = Integer.parseInt(age1);

        BufferedReader readerName = new BufferedReader( new InputStreamReader(System.in));
        String name1 = null;
        try {
            System.out.println("Write the name of the pet: ");
            name1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Age age = new Age();

        age.setYear(num1);

        ImmutableClass pet = new ImmutableClass(1,name1 , age);

        System.out.println(pet.getName() + " age year before modification = " + pet.getAge().getYear());

        BufferedReader readerName2 = new BufferedReader( new InputStreamReader(System.in));
        String age2 = null;
        try {
            System.out.println("Change the age of the pet: ");
            age2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int num2 = Integer.parseInt(age2);
        age.setYear(num2);

        System.out.println(pet.getName() + " age year after modification = " + pet.getAge().getYear());

    }
}
