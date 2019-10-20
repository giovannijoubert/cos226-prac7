import java.util.LinkedList;
import java.util.ListIterator;

public class Executor {
	
	public static void main (String[] args) {
		int depositCount = Integer.parseInt(args[0]); //number of threads that can deposit
		int withdrawCount = Integer.parseInt(args[1]); //number of threads that can withdraw
		long initialAmount = Integer.parseInt(args[2]); //Initial amount in account
		
		SavingsAccount savings = new SavingsAccount(initialAmount);
				
		LinkedList<Thread> threads = new LinkedList<Thread>();

		for (int i = 0; i < depositCount; i++)
		{
			threads.add(new DepositThread(savings));
		}
		
		for (int i = 0; i < withdrawCount; i++)
		{
			threads.add(new WithdrawThread(savings));
		}

		// Start the threads
		ListIterator<Thread> iterator = threads.listIterator();
    
		while (iterator.hasNext())
			iterator.next().start();
    
		// Wait for all of the threads to finish executing

		while (iterator.hasPrevious()) {
			try {
			{
				iterator.previous().join();
			}    
			} catch (InterruptedException exception) { }
		}
		
		

		
		
	}
}