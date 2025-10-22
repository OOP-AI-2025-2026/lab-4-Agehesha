
package org.example.lab4.bank;

import org.example.lab4.docsmodel.BankingAccount;
import org.example.lab4.docsmodel.Startup;

public class MinMaxAccount extends BankingAccount {
    private int min;
    private int max;

    public MinMaxAccount(Startup s) {
        super(s);
        this.min = this.max = this.balanceCents;
    }

    @Override
    public void credit(int cents) {
        super.credit(cents);
        if (balanceCents > max) max = balanceCents;
        if (balanceCents < min) min = balanceCents;
    }

    @Override
    public void debit(int cents) {
        super.debit(cents);
        if (balanceCents > max) max = balanceCents;
        if (balanceCents < min) min = balanceCents;
    }

    public int getMin() { return min; }
    public int getMax() { return max; }
}
