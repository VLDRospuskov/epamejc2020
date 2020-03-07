package homeworks.homework9_multithreading.model;

import homeworks.homework9_multithreading.exception.AccountNotFoundException;
import homeworks.homework9_multithreading.exception.BankIsBankrotEception;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class Bank {
    @Getter
    private volatile BigDecimal balance;
    private final List<Account> accounts;

    public synchronized BigDecimal getAccountBalance(Long card){
        Account account = accounts
                .stream()
                .filter(account1 -> account1.getCard().equals(card))
                .findAny()
                .orElseThrow(()->new AccountNotFoundException(String.valueOf(card)));
        return account.getBalance();
    }

    public synchronized String updateAccountBalance(Long card, BigDecimal balance){
        Account account = accounts
                .stream()
                .filter(account1 -> account1.getCard().equals(card))
                .findAny()
                .orElseThrow(()->new AccountNotFoundException(String.valueOf(card)));
        int index = accounts.indexOf(account);
        account.setBalance(balance);
        accounts.set(index,account);
        return "Balance updated";
    }

    public synchronized BigDecimal getMoney(BigDecimal amount) {

        if (balance.compareTo(amount) >= 0){
            balance = balance.subtract(amount);
            return amount;
        } else {
            throw new BankIsBankrotEception("Bank is bankrot");
        }

    }
}
