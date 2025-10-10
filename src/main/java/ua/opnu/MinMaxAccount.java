package ua.opnu;


public class MinMaxAccount extends BankingAccount {
private int min;
private int max;


public MinMaxAccount(Startup s) {
super(s);
int bal = getBalance();
this.min = bal;
this.max = bal;
}


public void debit(int amount) {
super.debit(amount);
touch(getBalance());
}


public void credit(int amount) {
super.credit(amount);
touch(getBalance());
}


private void touch(int bal) {
if (bal < min) min = bal;
if (bal > max) max = bal;
}


public int getMin() { return min; }
public int getMax() { return max; }
}
