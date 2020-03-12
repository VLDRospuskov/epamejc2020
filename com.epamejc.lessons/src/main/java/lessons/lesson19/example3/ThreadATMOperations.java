package lessons.lesson19.example3;

import java.util.Random;

public class ThreadATMOperations extends Thread {
    
    private final ATM atm;
    
    public ThreadATMOperations(ATM atm, User user) {
        super(user.getName());
        this.atm = atm;
    }
    
    @Override
    public void run() {
        while (true) {
            final Boolean chooseOperation = generateRandomBoolean();
            if (chooseOperation) {
                atm.withdraw(generateRandomAmount());
            } else {
                atm.deposit(generateRandomAmount());
            }
        }
    }
    
    private Boolean generateRandomBoolean() {
        return new Random().nextInt() > 0;
    }
    
    private Integer generateRandomAmount() {
        return new Random().nextInt(100);
    }
    
}
