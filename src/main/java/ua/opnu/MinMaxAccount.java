package ua.opnu;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {
    private int min;
    private int max;

    public MinMaxAccount(Startup s) {
        super(s);
        int start = getBalance();
        this.min = start;
        this.max = start;
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        updateMinMax();
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        updateMinMax();
    }

    private void updateMinMax() {
        int b = getBalance();
        if (b < min) min = b;
        if (b > max) max = b;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
