package lessons.java.lesson19.example3;

public class Main {

    public static void main(String[] args) {
        final ATM atm = new ATM(500);
        final User vladimir = new User("Vladimir");
        final User boris = new User("Boris");
        final User dmitrii = new User("Dmitrii");
        final User maria = new User("Maria");

        final ThreadATMOperations threadATMOperations = new ThreadATMOperations(atm, vladimir);
        final ThreadATMOperations threadATMOperations1 = new ThreadATMOperations(atm, boris);
        final ThreadATMOperations threadATMOperations2 = new ThreadATMOperations(atm, dmitrii);
        final ThreadATMOperations threadATMOperations3 = new ThreadATMOperations(atm, maria);

        threadATMOperations.start();
        threadATMOperations1.start();
        threadATMOperations2.start();
        threadATMOperations3.start();
    }
}
