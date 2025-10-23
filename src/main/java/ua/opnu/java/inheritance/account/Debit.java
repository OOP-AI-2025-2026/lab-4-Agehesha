package ua.opnu.java.inheritance.account;

public final class Debit implements Operation {
    private final int cents;

    public Debit(int cents) {
        this.cents = cents;
    }

    public int getCents() {
        return cents;
    }

    @Override
    public void apply(BankingAccount account) {
        if (account != null) {
            account.debit(cents);
        }
    }
}
