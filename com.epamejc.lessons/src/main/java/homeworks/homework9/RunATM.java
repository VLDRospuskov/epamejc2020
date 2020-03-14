package homeworks.homework9;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class RunATM {
    
    private static int atmId;
    private static int userId;
    
    public static void main(String[] args) {
        
        ATM.setGlobalBalance(new BigDecimal(2_000_000_000));
        
        List<ATM> atmList = generateATMList();
        
        List<Client> clientList = generateClientList();
        
        ThreadOperations.clientList = clientList;
        
        new Thread(() -> {
            while (ATM.getGlobalBalance()
                      .intValue() > 0) {
                try {
                    sleep(new Random().nextInt(2000));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                for (ATM atm : atmList) {
                    if (atm.getATMBalance()
                           .compareTo(new BigDecimal("200000")) < 0) {
                        if (ATM.getGlobalBalance()
                               .compareTo(new BigDecimal(100_000)) < 0) {
                            atm.setATMBalance(atm.getATMBalance()
                                                 .add(ATM.getGlobalBalance()));
                            ATM.setGlobalBalance(new BigDecimal(0));
                        } else {
                            atm.setATMBalance(atm.getATMBalance()
                                                 .add(new BigDecimal(600_000)));
                            ATM.setGlobalBalance(ATM.getGlobalBalance()
                                                    .subtract(new BigDecimal(600_000)));
                            System.out.println("Added 600_000 to ATM from global balance");
                        }
                    } else if (atm.getATMBalance()
                                  .compareTo(new BigDecimal(2_000_000)) > 0) {
    
                        ATM.setGlobalBalance(ATM.getGlobalBalance()
                                                .add(new BigDecimal(1_500_000)));
                        atm.setATMBalance(atm.getATMBalance()
                                             .subtract(new BigDecimal(1_500_000)));
                        System.out.println("Subtract 1_500_000 from ATM to global balance");
                    }
                }
            }
        }).start();
        
        List<ThreadOperations> threadOperationsList = generateThreadOperationsList(atmList, clientList);
        for (ThreadOperations threadOperations :
                threadOperationsList) {
            threadOperations.start();
        }
        
    }
    
    private static List<Client> generateClientList() {
        int size = generateIntInRange(7, 13);
        List<Client> clientList = new ArrayList<>(size);
        for (int j = 0; j < size; j++) {
            clientList.add(new Client(randomBigDecimal(), "#" + userId++));
        }
        return clientList;
    }
    
    private static List<ATM> generateATMList() {
        int size = generateIntInRange(5, 10);
        List<ATM> atmList = new ArrayList<>(size);
        for (int j = 0; j < size; j++) {
            atmList.add(new ATM(atmId++, randomBigDecimal()));
        }
        return atmList;
    }
    
    private static int generateIntInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + 3;
    }
    
    private static BigDecimal randomBigDecimal() {
        return new BigDecimal(generateIntInRange(10_000_000, 100_000_000));
    }
    
    private static ThreadOperations randomThreadOperation(List<ATM> atms, List<Client> clients) {
        return new ThreadOperations(atms.get(new Random().nextInt(atms.size())),
                                    clients.get(new Random().nextInt(clients.size())));
    }
    
    private static List<ThreadOperations> generateThreadOperationsList(List<ATM> atms, List<Client> clients) {
        int size = generateIntInRange(7, 20);
        List<ThreadOperations> threadOperationsList = new ArrayList<>(size);
        for (int j = 0; j < size; j++) {
            threadOperationsList.add(randomThreadOperation(atms, clients));
        }
        return threadOperationsList;
    }
    
}
