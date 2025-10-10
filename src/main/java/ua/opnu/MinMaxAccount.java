package ua.opnu;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {

    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup startup) {
        super(startup);
        int b = getBalance();
        this.minBalance = b;
        this.maxBalance = b;
    }


    @Override
    public void credit(Credit credit) {
        super.credit(credit);
        int b = getBalance();
        if (b < minBalance) {
            minBalance = b;
        }
        if (b > maxBalance) {
            maxBalance = b;
        }
    }


    @Override
    public void debit(Debit debit) {
        super.debit(debit);
        int b = getBalance();
        if (b < minBalance) {
            minBalance = b;
        }
        if (b > maxBalance) {
            maxBalance = b;
        }
    }


    public int getMin() {
        return minBalance;
    }


    public int getMax() {
        return maxBalance;
    }
}
