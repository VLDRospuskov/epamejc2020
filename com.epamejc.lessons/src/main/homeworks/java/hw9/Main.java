package homeworks.java.hw9;

public class Main {

    public static void main(String[] args) {
        final Bank bank = new Bank(50000);
        final ATM atm111 = new ATM(500, 111);
        final ATM atm57 = new ATM(500, 57);
        final ATM atm17 = new ATM(500, 17);
        final User vladimir = new User("Vladimir", 22000.00);
        final User boris = new User("Boris", 15000.50);
        final User dmitrii = new User("Dmitrii", 75000.70);
        final User maria = new User("Maria", 500.00);

        final ThreadATMOperations threadATMOperations = new ThreadATMOperations(bank, atm111, vladimir);
        final ThreadATMOperations threadATMOperations1 = new ThreadATMOperations(bank, atm57, boris);
        final ThreadATMOperations threadATMOperations2 = new ThreadATMOperations(bank, atm17, dmitrii);
        final ThreadATMOperations threadATMOperations3 = new ThreadATMOperations(bank, atm111, maria);

        threadATMOperations.start();
        threadATMOperations1.start();
        threadATMOperations2.start();
        threadATMOperations3.start();
    }
}
