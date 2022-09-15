package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		
		Scanner fetch= new Scanner (System.in);
		
		//Intput
		System.out.println("How much money do you start with?");
		int startAmount=fetch.nextInt();
		System.out.println("What is the win chance?");
		double winChance= fetch.nextDouble();
		System.out.println("What is you win limit?");
		int winLimit=fetch.nextInt();
		System.out.println("How many simulations will you like to run?");
		int totalSimulations=fetch.nextInt();
		
		//Loops
		
		int losses=0;
		int i=1;
		while(i<=totalSimulations)
		{
			int totalMoney=startAmount;
			int j;
			
			for(j=0;(totalMoney!=winLimit)&&(totalMoney!=0);j++)
			{
				
				double randomNum= Math.random();
				if (randomNum>winChance)
				{
					totalMoney--;
				}
				else
				{
					totalMoney++;
				}
				
				
			}
		
			
			if (totalMoney==winLimit)
			{
				System.out.println("Simulation "+i+": "+j+" WIN");
			
			}
			else
			{
				System.out.println("Simulation "+i+": "+j+" LOSE");
				losses++;
			}
			
			i++;
		}
		double expectedRuinRate;
		
		double realRuinRate=(double)losses/totalSimulations;
		
		if (winChance==0.5)
		{
		expectedRuinRate= 1-(startAmount/winLimit);
		}
		else
		{
		expectedRuinRate=(double)(((double)(1-startAmount)/startAmount)-(double)((double)(1-winLimit)/winLimit))/(double)(1-(double)((double)(1-winLimit)/(winLimit)));
		}
		
		
		System.out.println("Losses: "+losses+" Simutlations: "+totalSimulations);
		System.out.println("Ruin Rate from Simulation: "+realRuinRate+" Expected Ruin Rate:"+expectedRuinRate);
		
		
			
		
	}

}
