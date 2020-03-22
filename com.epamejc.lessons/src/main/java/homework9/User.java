package homework9;

import lombok.SneakyThrows;

import java.util.Random;

class User implements Runnable {
    private Integer id;
    private Bank bank;

    User(Integer id, Bank bank) {
        this.id = id;
        this.bank = bank;
    }

    @SneakyThrows
    @Override
    public void run() {
        int wait;

        for (int i = 0; i < 1000; i++) {
            wait = new Random().nextInt(1000) + 1000;
            if (wait % 2 == 0) {
                putMoney();
            } else {
                getMoney();
            }
            System.out.println(id + "-wait-" + wait);
            Thread.sleep(wait);
        }
    }

    private synchronized void putMoney() {
        int sum = new Random().nextInt(100);
        bank.putMoney(id, sum);
    }

    private synchronized void getMoney() {
        int sum = new Random().nextInt(100);
        bank.getMoney(id, sum);
    }


}
