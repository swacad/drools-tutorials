package droolscours;

public class Account {
	private long accountno;
	private double balance;
	public long getAccountNo() {
		return accountno;
	}
	public void setAccountNo(long accountno) {
		this.accountno = accountno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", balance=" + balance + "]";
	}

}
