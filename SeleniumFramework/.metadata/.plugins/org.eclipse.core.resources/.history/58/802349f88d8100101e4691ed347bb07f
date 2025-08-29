package NumberBased_Programs;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		//How many number in a series to be generate
		System.out.println("Enter a number");
		Scanner scr = new Scanner(System.in);
		int seriesDigit = scr.nextInt();
		
		//Initialize first second and third numbers in a series
		int firstDigit =0, secondDigit=1, thirdDigit;
		
		//Print fibonacci series 0 1 1 2 3 5 8 13.... (c = a + b)
		System.out.println("Fibonacci Series of " + seriesDigit + " numbers are: ");
			
		for(int i=0; i<seriesDigit; i++)  //Loop to print digits
		{
			System.out.print(firstDigit + " ");
			thirdDigit = firstDigit + secondDigit;
			firstDigit = secondDigit;
			secondDigit = thirdDigit;
		}

	}

}
