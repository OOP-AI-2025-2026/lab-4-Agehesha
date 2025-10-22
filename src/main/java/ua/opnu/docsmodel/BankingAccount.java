
package org.example.lab4.docsmodel;


public class BankingAccount {
    protected int balanceCents;

    public BankingAccount(Startup s) {
        this.balanceCents = s == null ? 0 : s.getInitialCents();
    }

 
    public void credit(int cents) {
        if (cents > 0) balanceCents += cents;
    }


    public void debit(int cents) {
        if (cents > 0) balanceCents -= cents;
    }

    public int getBalance() {
        return balanceCents;
    }
}
