//Thread that can only deposit money into the account
public class DepositThread extends Thread {
	
	SavingsAccount savings;
	long amount;
	
	public DepositThread(SavingsAccount s) {
		savings = s;
	}
	
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				long duration = (long)(Math.random()*5000);
				Thread.sleep(duration);	//Thread sleeps random amount of time between attempts
			} catch (InterruptedException e) {}
		
			amount = (long)(Math.random()*100.00);

			System.out.println("Depositing: R" + amount); 
			savings.deposit(amount); 		//Thread deposits random amount of money into account
		}
	}
}