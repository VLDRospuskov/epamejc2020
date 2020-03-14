package homeworks.homework9;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class ThreadOperations extends Thread {
    
    public static List<Client> clientList;
    private final ATM atm;
    private final Client client;
    
    public ThreadOperations(ATM atm, Client client) {
        this.atm = atm;
        this.client = client;
    }
    
    private static int generateIntInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + 3;
    }
    
    //2_147_483_648
    private static BigDecimal getSomeMoneyToPerform() {
        return new BigDecimal(generateIntInRange(10_000, 100_000));
    }
    
    @Override
    public void run() {
        while (true) {
            executeRandomOperation();
        }
    }
    
    public Client getClient() {
        return client;
    }
    
    public void executeRandomOperation() {
        final int chooseOperation = new Random().nextInt(3);
        BigDecimal someMoneyToPerform = getSomeMoneyToPerform();
        switch (chooseOperation) {
            case 0:
                withdraw(someMoneyToPerform);
                break;
            case 1:
                atm.deposit(someMoneyToPerform);
                client.setAccountMoney(client.getAccountMoney()
                                             .add(someMoneyToPerform));
                break;
            case 2:
                atm.checkClientAndATMBalance();
                break;
        }
        try {
            sleep(new Random().nextInt(2000));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void withdraw(BigDecimal generatedRandomAmount) {
        if (generatedRandomAmount.compareTo(client.getAccountMoney()) > 0) {
            return;
        }
        if (atm.withdraw(generatedRandomAmount)) {
            client.setAccountMoney(client.getAccountMoney()
                                         .subtract(generatedRandomAmount));
        }
    }
    
}
