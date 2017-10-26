/********************************************************************************************
 * 
 * File Name : Prime_Thread_Starter.java
 * 
 * Authors : Sreeram Pulavarthi
 * 
 * Group #: 12
 * 
 * Date: 10-16-2017
 * 
 * Compiler Used: Java 1.8
 * 
 * Description of File: Takes the input from user for calculating the number of Primes in given range...... 
 * 						Gets the input from user for number of threads to be created.....  
 * 						Creates the thread and runs the thread....
 * 
 *********************************************************************************************
 */

import java.io.*;
import java.util.*;

	public class Prime_Thread_Starter {
		
		// Maintains the status of each thread which is created at runtime 
		
		static ArrayList<Prime_Threads_p1> pt= new ArrayList<Prime_Threads_p1>();  
				
		int numb_rang=0, threads_rang=0, interval_set=0, curr=0, prev=0;
		
		// Instances the scanner class to get the input form user
		
		Scanner in = new Scanner(System.in);
		
		public Prime_Thread_Starter() {
			// TODO Auto-generated constructor stub
			
			System.out.println("Enter the number of prime numbers range to be calculated: ");
			
			numb_rang = in.nextInt();
			
			//System.out.println(" Entered number range "+numb_rang);
			
			System.out.println("Enter the number of threads to be created: ");
			
			threads_rang = in.nextInt();
			
			interval_set = numb_rang/threads_rang;
			
			System.out.println("#####################################################################");
			System.out.println("\n#Threads = "+threads_rang);
			
			for (int i = 0;i<threads_rang;i++) {
				
				prev = curr+interval_set;
				
				// Creates thread and passes the input details like starting range and ending range of numbers for each thread 
				
				Prime_Threads_p1 PT = new Prime_Threads_p1(curr,prev,i);

				pt.add(PT);
				
				curr= curr+interval_set;
			}
		}
		

		public static void main(String[] args) throws InterruptedException {
			
			
			System.out.println("Thread is calling --> ");
			
			// Calls the constructor and strts the threads from arraylist
			
			new Prime_Thread_Starter();
			
			for (int j=0;j<pt.size();j++)
			{	
				if (j ==1){
					
					pt.get(j).setPriority(8);
					pt.get(j).start();
				
				}
				else
				{
					pt.get(j).sleep(20000);
					pt.get(j).start();
					
				}
				try {
					pt.get(j).join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}