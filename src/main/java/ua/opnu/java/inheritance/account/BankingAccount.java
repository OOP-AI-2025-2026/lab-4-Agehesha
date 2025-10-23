package ua.opnu.java.inheritance.account;


public class BankingAccount {
    protected int balanceCents;

    public BankingAccount(Startup s) {
        this.balanceCents = (s == null) ? 0 : s.getInitialCents();
    }

    public void credit(int cents) {
        balanceCents += cents;
    }

    public void debit(int cents) {
        balanceCents -= cents;
    }

    public int getBalance() {
        return balanceCents;
    }
}
