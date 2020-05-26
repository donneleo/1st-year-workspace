import java.util.Random;
import java.util.Scanner;

  public class HiLowCard 
  {
	 
	 public static final int MAX_NUMBER = 13;
	 public static final int MIN_NUMBER = 2;
	 public static final int MAX_GUESSES = 4;
	 public static final String HIGHER = "higher";
	 public static final String LOWER = "lower";
	 public static final String EQUAL = "equal";		 
	  
	 public static void main(String[] args) 
	 {
		Random generator = new Random();
		Scanner inputScanner = new Scanner(System.in);
		
		int correctGuesses = 0;
		int guessCount = 0;
		int oldNumber = generator.nextInt(MAX_NUMBER - 1) + 1;
		int newNumber = generator.nextInt(MAX_NUMBER - 1) + 1;
		boolean finished = false;
		
		try{
			do
			{	
			  if(oldNumber == 11) 
		      {
			    System.out.println("This card is an Jack.");
		      }else if(oldNumber == 12)
		      {
			    System.out.println("This card is a Queen");
		      }else if(oldNumber == 13) 
		      {
			    System.out.println("This card is a King");
		      }else if(oldNumber == 14) 
		      {
			    System.out.println("This card is a Ace");
		      }else 
		      {
			    System.out.println("This card is a " + oldNumber + ".");
		      }
			   for(guessCount = 0; guessCount < MAX_GUESSES; guessCount++) 
			   {
				   System.out.println("Will the next card be higher, lower or equal?\n");
				   if( inputScanner.hasNext(LOWER) || inputScanner.hasNext(HIGHER) || inputScanner.hasNext(EQUAL)) 
				   {
					   if(((inputScanner.hasNext(LOWER)) && (oldNumber > newNumber)) || ((inputScanner.hasNext(HIGHER)) && (oldNumber < newNumber))
							   || ((inputScanner.hasNext(EQUAL)) && (oldNumber == newNumber))) 
					   {
						   correctGuesses++;
					   } 
					   if(newNumber == 14) 
		               {
			              System.out.println("This card is an Ace.");
		               }else if(newNumber == 11)
		               {
			              System.out.println("This card is a Jack");
		               }else if(newNumber == 12) 
		               {
			              System.out.println("This card is a Queen");
		               }else if(newNumber == 13) 
		               {
			              System.out.println("This card is a King");
		               }else 
		               {
			              System.out.println("This card is a " + newNumber + ".");
		               }
					   
					   oldNumber = newNumber;
					   newNumber = generator.nextInt(MAX_NUMBER + 1);
					   
				   }else if(inputScanner.hasNext("quit")) 
				   {
					   System.out.println("Thanks for playing.");
					   finished = true;
					   
				   } 
		           else 
				   {
					   System.out.println("Invalid Input. Please try again.");
					   guessCount = -1;
				   }
				   
				   inputScanner.next();
			   }
			   if(correctGuesses != MAX_GUESSES) 
			   {
				   System.out.println("You only got " + correctGuesses + " correct. Bad luck.");
				   finished = true;
			   }
			   else 
			   {
				   System.out.println("Congratulations. You win.");
				   finished = true;
			   }
			   
			}while(!finished);
	    }
		catch(ArithmeticException exception)  
		{
			System.err.printf ( "\nException thrown: %s\n", exception );
		}
		
	 }

  }
