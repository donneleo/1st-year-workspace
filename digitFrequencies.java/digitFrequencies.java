import java.util.Scanner;

public class digitFrerquency 
{
	public static final int NO_OF_DIGITS = 10;


	public static void main(String[] args) 
	{
		int[] frequencies = new int[NO_OF_DIGITS];	


		for(int index = 0; (index < frequencies.length); index++) 
		{
			frequencies[index] = 0;
		}

		while(true) 
		{	
			System.out.println("Please enter a number");
			Scanner inputScanner = new Scanner(System.in);
			if(inputScanner.hasNextInt()) 
			{
				int number = inputScanner.nextInt();
				countDigitFrequencies(number, frequencies);
				printDigitFrequencies(frequencies);
			}else 
			{
				System.out.println("No number inputed");
			}
		}
	}

	public static void countDigitFrequencies(int number, int[] frequencies) 
	{
		int remainder = Math.abs(number);
		int digit = 0;
		while (remainder > 0)
			
		{
			digit = remainder % 10;
			remainder /= 10;
			frequencies[digit]++;
		}
	}
	public static void printDigitFrequencies( int[]frequencies) 
	{
		if(frequencies != null) 
		{

			for(int index = 0; (index < frequencies.length); index++) 
			{
				if(frequencies[index] > 0) 
				{ 
					System.out.println(index + "(" + frequencies[index] + ") ");
				}
			}
		}
	}
}
