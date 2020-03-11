package homeworks.multiThreading;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static homeworks.multiThreading.ThreadController.locker;

@AllArgsConstructor
public class ThreadATMOperations extends Thread {

    public Bank bank;
    public List<User> users;
    public List<ATM> atms;
    private BigDecimal max;
    private BigDecimal min;

    @SneakyThrows
    public void run() {

        while (true) {

            TimeUnit.SECONDS.sleep(1);

            bank.controlATM(atms, max, min);
            if (bank.bankrupt || users.size() <= 0) {
                break;
            }

            int userIndex = getRandomIndex(users);
            int atmIndex = getRandomIndex(atms);

            commitRandomOperation(userIndex, atmIndex);
            System.out.println();
        }
    }

    private void commitRandomOperation(int userIndex, int atmIndex) {

        locker.lock();
        if (users.size() > userIndex) {
            if (users.get(userIndex).chooseRandomOperation()) {
                userDeposit(users.get(userIndex), atms.get(atmIndex));
            } else {
                userWithdraw(users.get(userIndex), atms.get(atmIndex));
            }
            if (users.get(userIndex).bankrupt) {
                UsersSum.sum = UsersSum.sum.add(users.remove(userIndex).getBalance());
            }
        }
        locker.unlock();
    }

    private int getRandomIndex(List<?> list) {
        return new Random(System.currentTimeMillis()).nextInt(list.size());
    }

    private void userWithdraw(User user, ATM atm) {

        BigDecimal amount = user.getRandomAmount();

        boolean success = atm.withdraw(amount);
        user.setBalance(user.getBalance().add(amount), success);

    }

    private void userDeposit(User user, ATM atm) {

        BigDecimal amount = user.getRandomAmount();

        if (user.getBalance().compareTo(BigDecimal.valueOf(5)) > 0) {
            atm.deposit(amount);
            user.setBalance(user.getBalance().subtract(amount));
        } else {
            user.bankrupt = true;
            System.out.println("User: " + user.getName() + " bankrupt!");
        }

    }
}
