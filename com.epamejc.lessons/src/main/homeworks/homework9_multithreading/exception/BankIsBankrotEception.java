package homeworks.homework9_multithreading.exception;

public class BankIsBankrotEception extends RuntimeException {

    public BankIsBankrotEception(String message) {
        super(message);
    }
}
