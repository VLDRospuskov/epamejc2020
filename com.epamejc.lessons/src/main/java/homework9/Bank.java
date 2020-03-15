package homework9;

import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<Integer, Integer> UsersAccount = new HashMap<>();

    synchronized void putMoney(Integer id, int count) {
        int balance;
        try {
            balance = UsersAccount.get(id) + count;
            System.out.println("Balance replenished - " + id);
        } catch (NullPointerException e) {
            balance = count;
            System.out.println("Create account - " + id);
        }
        UsersAccount.put(id, balance);
        System.out.println(id + " Balance - " + balance);
    }

    synchronized void getMoney(Integer id, int count) {
        int balance;
        try {
            if (UsersAccount.get(id) < count) {
                System.out.println("Not enough money - " + id);
                balance = UsersAccount.get(id);
            } else {
                balance = UsersAccount.get(id) - count;
                System.out.println("Balance reduced - " + id);
            }
        } catch (NullPointerException e) {
            System.out.println("Create account - " + id);
            UsersAccount.put(id, 0);
            balance = 0;
        }
        UsersAccount.put(id, balance);
        System.out.println(id + " Balance - " + balance);
    }
}
