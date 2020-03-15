package homework9;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread user1 = new Thread(new User(1, bank));
        Thread user2 = new Thread(new User(2, bank));
        Thread user3 = new Thread(new User(3, bank));
        user1.start();
        user2.start();
        user3.start();
    }
}

