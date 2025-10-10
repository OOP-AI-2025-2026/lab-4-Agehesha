package ua.opnu;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {
  private int min;
  private int max;

  public MinMaxAccount(Startup s) {
    super(s);
    int bal = getBalance();
    this.min = bal;
    this.max = bal;
  }

  @Override
  public void credit(int amount) {
    super.credit(amount);
    updateMinMax();
  }

  @Override
  public void debit(int amount) {
    super.debit(amount);
    updateMinMax();
  }

  private void updateMinMax() {
    int bal = getBalance();
    if (bal < min) min = bal;
    if (bal > max) max = bal;
  }

  public int getMin() { return min; }
  public int getMax() { return max; }
}
