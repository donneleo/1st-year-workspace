/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7 ].
Comment: Although my ResolveBet took in more parameters, they were things that were necessary for me to write my code correctly.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment: The program told the player how much money they had in there wallet before asking how much they would like to bet.
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: The program told the player if they tried to bet more than they had in their wallet and told them to try again.
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15 ]..
Comment: My code created three dice objects, rolled them, added them up and displayed the result so that the player could see they weren't being cheated.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment: The code determines the winning by multiplying the initial bet by the odds that were associated with the particular games and then adding on the original bet.
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: The code outputs whether or not the player has won and deposits their winnings(if that is the case) into their wallet for them to use to bet. Money is removed if the
bet loses.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: The code asks the user how much money they had to start betting with and then creates a wallet in which the money is stored. 
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment: My code continues to ask the player if they want to bet. Once the wallet reaches zero or the player opts to leave the table, the betting ends and the player is given
a summary of their game. 
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment:The code asks the the player which type of bet they would like to make or if they would like to leave the table.
My program calls resolveBet for each bet type entered [Mark out of 5:5 ].
Comment: My code calls the resolveBet function in every loop so that they code can run.
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment:Once the game is over, the code thanks the player for playing and then gives the player a summary of their games, showing what they started with, how many bets they 
placed and what amount of money they finished.

 Total Mark out of 100 (Add all the previous marks): 100
 */


import java.util.Scanner;
import javax.swing.JOptionPane;

public class ChuckALuckDiceGame 
{

	public static void main(String[] args) 
	{
		Wallet playerWallet = new Wallet();

		try 
		{

			double money;
			String cashMoney = JOptionPane.showInputDialog(null, "Welcome to Chuck-A-Luck. What's in the wallet tonight?");
			Scanner cashScanner = new Scanner(cashMoney);
			money = cashScanner.nextDouble();
			playerWallet.put(money);
			cashScanner.close();

			int numberOfBets = 0;
			String ending = "";
			boolean finished = false;
			do 
			{
				String[] buttons = {"Triple", "Field", "High", "Low", "Leave Table"};

				int betType = JOptionPane.showOptionDialog(null, "Please enter your type of bet.", 
						"Pick your bet", JOptionPane.PLAIN_MESSAGE, 0, null, buttons, buttons[0]);
				if(betType == 4) 
				{
					finished = true;	
				}

				ResolveBet(betType, playerWallet, finished, cashMoney, ending, numberOfBets);
				numberOfBets++;
				switch(numberOfBets) 
				{
				case 1:
					ending = "";
				default:
					ending = "s";
				}

				if(playerWallet.check() == 0.00) 
				{
					finished = true;
					JOptionPane.showMessageDialog(null, "Sorry pal. Your all out of betting money. Your night is over.");
				}

			}while(!finished || playerWallet.check() < 0.00);

		}catch(NullPointerException exception) 
		{
			JOptionPane.showInputDialog("You didn't say how much to bet");
		}catch(java.util.NoSuchElementException exception) 
		{
			JOptionPane.showInputDialog("You didn't say how much to bet.");
		}
	}

	public static void ResolveBet(int betType, Wallet playerWallet, boolean finished, String cashMoney, String ending, int numberOfBets) 
	{
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();
		boolean playerWin = false;

		if(betType == 0) 
		{
			System.out.println("Here's the Rules:");
			System.out.println("The odds are 30/1. All three dice must show the same number, e.g. all 3s. However, the House wins if the three"
					+ " dice show all ones or all sixes.");
			String betAmount = JOptionPane.showInputDialog(null, "You've got " + playerWallet.check() + ". Please enter your bet.");
			Scanner betAmountScanner = new Scanner(betAmount);
			double bet = betAmountScanner.nextDouble();
			betAmountScanner.close();
			if(bet > playerWallet.check()) 
			{
				JOptionPane.showInputDialog("Don't think so buddy. Try again.");
			}
			playerWallet.get(bet);

			System.out.println(dice1.toString());
			System.out.println(dice2.toString());
			System.out.println(dice3.toString());

			if(((dice1.topFace() == 2 && dice2.topFace() == 2 && dice3.topFace() == 2)) || ((dice1.topFace() == 3 && dice2.topFace() == 3 && 
					dice3.topFace() == 3))	|| ((dice1.topFace() == 4 && dice2.topFace() == 4 && dice3.topFace() == 4)) || ((dice1.topFace() == 5
					&& dice2.topFace() == 5 && dice3.topFace() == 5))) 
			{
				playerWin = true;
				playerWallet.put((bet * 30) + bet);
				System.out.println("Congratulations. You win!");
			}
			else 
			{	
				System.out.println("Better luck next time, pal.");
			}
		}
		if(betType == 1) 
		{
			System.out.println("Here's the Rules:");
			System.out.println("The odds are 1/1. The total of the numbers shown on the three dice combined must be LESS than 8 or HIGHER"
					+ " than 12.");

			String betAmount = JOptionPane.showInputDialog(null, "You've got " + playerWallet.check() + ". Please enter your bet.");		
			Scanner betAmountScanner = new Scanner(betAmount);
			double bet = betAmountScanner.nextDouble();
			betAmountScanner.close();
			if(bet > playerWallet.check()) 
			{
				JOptionPane.showInputDialog("Don't think so buddy. Try again.");
			}
			playerWallet.get(bet);

			System.out.println(dice1.toString());
			System.out.println(dice2.toString());
			System.out.println(dice3.toString());

			int result = (dice1.topFace() + dice2.topFace() + dice3.topFace());
			System.out.println(result);
			if(result < 8)
			{
				playerWin = true;
				playerWallet.put((bet * 1) + bet);
				System.out.println("Congratulations. You Win!");
			}
			else if(result > 12) 
			{
				playerWin = true;
				playerWallet.put((bet * 1) + bet);
				System.out.println("Congratulations. You Win!");
			}
			else 
			{
				System.out.println("Better Luck Next Time.");
			}
		}
		if(betType == 2) 
		{
			System.out.println("Here's the Rules:");
			System.out.println("The odds are 1/1. In order to win, the total sum of the three dice must be higher than 10."
					+ " However, the House wins in the event that the sum is greater than 10 BUT made up of a tiple, e.g All 4s/5s/6s");
			String betAmount = JOptionPane.showInputDialog(null, "You've got " + playerWallet.check() + ". Please enter your bet.");
			Scanner betAmountScanner = new Scanner (betAmount);
			double bet = betAmountScanner.nextDouble();
			betAmountScanner.close();
			if(bet > playerWallet.check()) 
			{
				JOptionPane.showInputDialog("Don't think so buddy. Try again.");
			}
			playerWallet.get(bet);

			System.out.println(dice1.toString());
			System.out.println(dice2.toString());
			System.out.println(dice3.toString());
			
			int result = (dice1.topFace() + dice2.topFace() + dice3.topFace());
			System.out.println(result);

			if((result > 10) && (((dice1.topFace() != 4 && dice2.topFace() != 4 && dice3.topFace() != 4)) || ((dice1.topFace() != 5 && 
					dice2.topFace() != 5 && dice3.topFace() != 5)) || ((dice1.topFace() != 6 && dice2.topFace() != 6 && dice3.topFace() != 6))))
			{
				playerWin = true;
				playerWallet.put((bet * 1) + bet);
				System.out.println("Congratulations. You Win!");
			}
			else 
			{
				System.out.println("Better Luck Next Time.");
			}

		}
		if(betType == 3) 
		{
			System.out.println("Here's the Rules:");
			System.out.println("The odds are 1/1. In order to win, the total sum of the three dice must be lower than 11. However, the House"
					+ " wins in the event hat the sum is less than 11 BUT made up of a triple, e.g All 1s/2s/3s");
			String betAmount = JOptionPane.showInputDialog(null, "You've got " + playerWallet.check() + ". Please enter your bet.");
			Scanner betAmountScanner = new Scanner(betAmount);
			double bet = betAmountScanner.nextDouble();
			betAmountScanner.close();
			if(bet > playerWallet.check()) 
			{
				JOptionPane.showInputDialog("Don't think so buddy. Try again.");
			}
			playerWallet.get(bet);

			System.out.println(dice1.toString());
			System.out.println(dice2.toString());
			System.out.println(dice3.toString());
			
			int result = (dice1.topFace() + dice2.topFace() + dice3.topFace());
            System.out.println(result);
			if((result < 11) && (((dice1.topFace() != 1 && dice2.topFace() != 1 && dice3.topFace() != 1)) || ((dice1.topFace() != 2 && 
					dice2.topFace() != 2 && dice3.topFace() != 2)) || ((dice1.topFace() != 3 && dice2.topFace() != 3 && dice3.topFace() != 3))))
			{
				playerWin = true;
				System.out.println("Congratulations. You Win!");
				playerWallet.put((bet * 1) + bet);
			}
			else 
			{
				System.out.println("Better Luck Next Time.");
			}
		}
		if(betType == 4) 
		{
			finished = true;
			System.out.println("Thanks for playing tonight. Here's your summary:");
			System.out.println("You started with " + cashMoney + " euro, placed " + numberOfBets + " bet" + ending + ", and finished with " + 
					playerWallet.check() + " euro.");
		}
	}
}
