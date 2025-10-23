package ua.opnu.java.inheritance.account;

public final class Credit implements Operation {
    private final int cents;

    public Credit(int cents) {
        this.cents = cents;
    }

    public int getCents() {
        return cents;
    }

    @Override
    public void apply(BankingAccount account) {
        if (account != null) {
            account.credit(cents);
        }
    }
}
