//Threads that can only withdraw money from the account
public class WithdrawThread extends Thread {
	
	SavingsAccount savings;
	long amount;
	
	public WithdrawThread(SavingsAccount s) {
		savings = s;
	}
	
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				long duration = (long)(Math.random()*5000);
				Thread.sleep(duration);
			} catch (InterruptedException e) {}
			amount = (long)(Math.random()*100.00);

			System.out.println("Withdrawing: R" + amount);
			savings.withdraw(amount);
		}
	}
}