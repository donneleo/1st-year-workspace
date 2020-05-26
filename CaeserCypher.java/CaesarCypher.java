import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CaesarCypher {

	public static void main(String[] args) 
	{
		try {

			String[] buttons = {"Encrypt", "Decrypt"};

			int option = JOptionPane.showOptionDialog(null, "Do you want to encrypt or decrypt.", "Confirmation", JOptionPane.PLAIN_MESSAGE,
					0, null, buttons, buttons[0]);

			if(option == 0) 
			{
				boolean finished = false;
				do
				{
					String myString = JOptionPane.showInputDialog("Please enter a phrase to be encrypted, or type exit to quit.");
					Scanner inputScanner = new Scanner (myString);
					if(inputScanner.hasNext("exit")) 
					{
						finished = true;
						System.out.println("Thank you. Goodbye");
					}
					else 
					{
						char[] characterArray = myString.toCharArray();
						char[] encryptedMessage = encrypt(characterArray);

						String message = new String (encryptedMessage);

						System.out.println("Encrypted Message: " + message );

						inputScanner.close();
					}
				}while(!finished);
			}

			else if (option == 1) 
			{
				boolean finished = false;

				do
				{
					String decryptString = JOptionPane.showInputDialog(null, "Please enter a code to decrypt using the caeser cypher, or type exit to quit.");

					Scanner decryptScanner = new Scanner (decryptString);
					if(decryptScanner.hasNext("exit")) 
					{
						finished = true;
						System.out.println("Thank you. Goodbye.");
					}
					else
					{
						char[] characterArray = decryptString.toCharArray();

						char[] encryptedMessage = encrypt(characterArray);
						char[] decryptedMessage = decrypt(characterArray, encryptedMessage);

						String decryptedString = new String(decryptedMessage);

						System.out.println("Decrypted Message: " + decryptedString);

					}
				}while(!finished);  
			}
		}catch(NullPointerException exception) 
		{	
		}catch(java.util.NoSuchElementException exception) 
		{
			JOptionPane.showMessageDialog(null,"No phrase entered.");
		}
	}



	public static char[] encrypt(char[] characterArray) 
	{
		char character = ' ';
		char[] message = new char [0];

		for(int i = 0; (i < characterArray.length); i++) 
		{
			char nextNumber = (characterArray[i]);

			switch(nextNumber) 
			{
			case 'a':
				character = 'h';
				break;
			case 'b': 
				character = 'i';
				break;
			case 'c':
				character = 'j';
				break;
			case 'd':
				character = 'k';
				break;
			case 'e':
				character = 'l';
				break;
			case 'f':
				character = 'm';
				break;
			case 'g':
				character = 'n';
				break;
			case 'h':
				character = 'o';
				break;
			case 'i':
				character = 'p';
				break;
			case 'j':
				character = 'q';
				break;
			case 'k':
				character = 'r';
				break;
			case 'l':
				character = 's';
				break;
			case 'm':
				character = 't';
				break;
			case 'n':
				character = 'u';
				break;
			case 'o':
				character = 'v';
				break;
			case 'p':
				character = 'w';
				break;
			case 'q':
				character = 'x';
				break;
			case 'r':
				character = 'y';
				break;
			case 's':
				character = 'z';
				break;
			case 't':
				character = 'a';
				break;
			case 'u':
				character = 'b';
				break;
			case 'v':
				character = 'c';
				break;
			case 'w':
				character = 'd';
				break;
			case 'x':
				character = 'e';
				break;
			case 'y':
				character = 'f';
				break;
			case 'z':
				character = 'g';
				break;
			default:
				character = ' ';
				break;

			}
			message = Arrays.copyOf(message, message.length + 1);
			message[message.length - 1] = character;
		}

		return (message);
	}
	public static char[] decrypt(char[] characterArray, char[] encryptedMessage) 
	{
		char caeserLetter = ' ';
		char [] decryptedMessage = new char [0];

		for(int arrayIndex = 0; arrayIndex < characterArray.length; arrayIndex++) 
		{
			char letter = characterArray[arrayIndex];

			switch(letter) 
			{
			case 'a':
				caeserLetter = 't';
				break;
			case 'b':
				caeserLetter = 'u';
				break;
			case 'c':
				caeserLetter = 'v';
				break;
			case 'd':
				caeserLetter = 'w';
				break;
			case 'e':
				caeserLetter = 'x';
				break;
			case 'f':
				caeserLetter = 'y';
				break;
			case 'g':
				caeserLetter = 'z';
				break;
			case 'h':
				caeserLetter = 'a';
				break;
			case 'i':
				caeserLetter = 'b';
				break;
			case 'j':
				caeserLetter = 'c';
				break;
			case 'k':
				caeserLetter = 'd';
				break;
			case 'l':
				caeserLetter = 'e';
				break;
			case 'm':
				caeserLetter = 'f';
				break;
			case 'n':
				caeserLetter = 'g';
				break;
			case 'o':
				caeserLetter = 'h';
				break;
			case 'p':
				caeserLetter = 'i';
				break;
			case 'q':
				caeserLetter = 'j';
				break;
			case 'r':
				caeserLetter = 'k';
				break;
			case 's':
				caeserLetter = 'l';
				break;
			case 't':
				caeserLetter = 'm';
				break;
			case 'u':
				caeserLetter = 'n';
				break;
			case 'v':
				caeserLetter = 'o';
				break;
			case 'w':
				caeserLetter = 'p';
				break;
			case 'x':
				caeserLetter = 'q';
				break;
			case 'y':
				caeserLetter = 'r';
				break;
			case 'z':
				caeserLetter = 's';
				break;
			case ' ':
				caeserLetter = ' ';
			}

			decryptedMessage = Arrays.copyOf(decryptedMessage, decryptedMessage.length + 1);
			decryptedMessage[decryptedMessage.length - 1] = caeserLetter;
		}

		return (decryptedMessage);
	}
}


