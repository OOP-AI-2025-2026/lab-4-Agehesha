package ua.opnu.java.inheritance.account;

public class MinMaxAccount extends BankingAccount {
    private int min;
    private int max;

    public MinMaxAccount(Startup s) {
        super(s);
        this.min = balanceCents;
        this.max = balanceCents;
    }

    @Override
    public void credit(int cents) {
        super.credit(cents);
        updateMinMax();
    }

    @Override
    public void debit(int cents) {
        super.debit(cents);
        updateMinMax();
    }

    private void updateMinMax() {
        if (balanceCents < min) {
            min = balanceCents;
        }
        if (balanceCents > max) {
            max = balanceCents;
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
