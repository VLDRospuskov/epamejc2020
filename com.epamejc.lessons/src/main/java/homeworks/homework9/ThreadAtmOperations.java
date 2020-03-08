package homeworks.homework9;

public class ThreadAtmOperations extends Thread {

    private final ATM atm;
    private User user;

    public ThreadAtmOperations(ATM atm, User user) {
        super(user.getName());
        this.atm = atm;
        this.user = user;
    }

    @Override
    public void run() {
        
    }
}
