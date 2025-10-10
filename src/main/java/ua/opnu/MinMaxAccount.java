package ua.opnu;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

/**
 * Счёт, который отслеживает минимальный и максимальный баланс,
 * наблюдавшийся после операций.
 */
public class MinMaxAccount extends BankingAccount {
    private int minBalance;
    private int maxBalance;

    /** Удобный конструктор под тесты: стартовый баланс целым числом. */
    public MinMaxAccount(int startBalance) {
        this(new Startup(startBalance));
    }

    /** Базовый конструктор, если тесты/код передают Startup. */
    public MinMaxAccount(Startup startup) {
        super(startup);
        int bal = getBalance();
        this.minBalance = bal;
        this.maxBalance = bal;
    }

    /** Перегрузка под тесты: пополнение целым числом. */
    public void deposit(int amount) {
        super.deposit(new Credit(amount));
        int bal = getBalance();
        if (bal < minBalance) minBalance = bal;
        if (bal > maxBalance) maxBalance = bal;
    }

    /** Перегрузка под тесты: списание целым числом. */
    public void withdraw(int amount) {
        super.withdraw(new Debit(amount));
        int bal = getBalance();
        if (bal < minBalance) minBalance = bal;
        if (bal > maxBalance) maxBalance = bal;
    }

    public int getMin() { return minBalance; }
    public int getMax() { return maxBalance; }
}
