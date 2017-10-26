/********************************************************************************************
 * 
 * File Name : Prime_Threads_p1.java
 * 
 * Authors : Sreeram Pulavarthi
 * 
 * Group #: 12
 * 
 * Date: 10-16-2017
 * 
 * Compiler Used: Java 1.8
 * 
 * Description of File: Creates thread for each time constructor called from the main class...... 
 * 						Calculates the prime numbers in the given range .....  
 * 						Calculates the time taken for each thread to start and complete....
 * 
 *********************************************************************************************
 */

import java.io.*;

public class Prime_Threads_p1 extends Thread {

	
	int start_num = 0,prime_cntr=0,end_num = 0,i ,thrd_id;
	
	static int  tp=0;
	
	double startTime= 0,cnvrtdestimatedTime=0,estimatedTime=0;
	
	public Prime_Threads_p1(int start, int end, int id) {
		// TODO Auto-generated constructor stub
		
		start_num = start;
			
		end_num = end;
		
		thrd_id =id;
		
	}
	
	public boolean isPrime(int n) {
			
			if (n % 2 == 0) return false;
			
			int breaker = (int)Math.ceil(Math.sqrt((double)n));
			
			// Logic to check if the integer received is an prime or not
			
			for (int strtran = 3; strtran <= breaker; strtran +=2)
				if (n % strtran == 0)
				return false;
			
			return true; 
			
	}
	
	public void CalcPrimes(int start_num, int end_num, int id)
	{
		startTime = System.nanoTime();	
		
		// TODO Auto-generated method stub
		
		// Sends the number to the function isprime
		
		for ( i=start_num ; i < end_num ;i++) {
				
			if (isPrime(i)) {
				prime_cntr += 1;
				}	
			}
		
		estimatedTime = (System.nanoTime() - startTime);
		
		cnvrtdestimatedTime = estimatedTime/(1000000000.0);
		
		tp += prime_cntr;
		
	}
	

	@Override
	public void run() {
		
		CalcPrimes(start_num, end_num, thrd_id);
		
		// Displays time taken and prime numbers calculated for each thread
		
		System.out.println("Thread #"+thrd_id+" Prime Count = "+prime_cntr+"\n # Seconds used = "+cnvrtdestimatedTime+"\n Total Prime count = "+ tp+"\n");
		
	}

}
