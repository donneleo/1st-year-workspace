import java.util.Scanner;

public class NaughtsAndCrosses 
{
	public static final int NO_OF_ROWS = 3;
	public static final int NO_OF_COLUMNS = 3;
	public static final char BOARD_FILLER = ' ';
	public static final int MAX_NO_OF_MOVES = 9;
	public static final char[][] board = new char[NO_OF_ROWS][NO_OF_COLUMNS];


	public static void main(String[] args) 
	{
		clearBoard(board);
		int turn = 1;
		boolean finished = false;
		isBoardFull(board, turn, finished);

		try 
		{
			do
			{
				int row = 0;																	
				int column = 0;
				printBoard(board);
				char currentPlayerPiece = ' '; 
				System.out.println("Please enter where you would like the place your move (with row and column are seperated by a space)" );
				Scanner inputScanner = new Scanner(System.in);

				row = (inputScanner.nextInt() - 1);	
				if(row <= -1 || row > 2) 
				{
					System.out.println("Invalid input.");
				}

				column = (inputScanner.nextInt() - 1);

				if(column <= -1 || column > 2) 
				{
					System.out.println("Invalid input.");
				}

				boolean canMove = canMakeMove(board, row, column);
				if (canMove == true) 
				{
					if(turn % 2 != 0) 
					{
						currentPlayerPiece = 'X';
						makeMove(board, currentPlayerPiece, row, column);
						turn++;
					}
					else if (turn % 2 == 0)
					{
						currentPlayerPiece = 'O';
						makeMove(board, currentPlayerPiece, row, column);
						turn++;
					}
				}
				else if (canMove == false) 
				{
					System.out.println("Invalid move.");
				}

				char winner = winner(board, finished);
				if(winner == 'D') 
				{
					System.out.println("");
				}
				else 
				{
				System.out.println("The winner is " + winner + "\n");
				finished = true;
				}
			}while(!finished);			

		}catch(ArrayIndexOutOfBoundsException exception) 
		{	
			
		}catch(NullPointerException exception)
		{	
			
		}catch(NegativeArraySizeException exception) 
		{
			
		}catch(java.util.NoSuchElementException exception)
		{
			
		}

	}

	public static void clearBoard(char[][] board) 
	{
		for(int row = 0; (row < board.length); row++)
			for(int column = 0; (column < board[row].length); column++) 
				board[row][column] = BOARD_FILLER;
	}
	public static void printBoard(char[][] board) 
	{
		System.out.println("[" + board[0][0] + "] [" + board[0][1] + "] [" + board[0][2] + "]");
		System.out.println("[" + board[1][0] + "] [" + board[1][1] + "] [" + board[1][2] + "]");
		System.out.println("[" + board[2][0] + "] [" + board[2][1] + "] [" + board[2][2] + "]");
	}	
	public static boolean canMakeMove(char[][] board, int row, int column) 
	{
		boolean canMakeMove;

		if(board[row][column] == 'X' || board[row][column] == 'O') 
		{
			canMakeMove = false;
			System.out.println("This is an inavlid move.");
		}
		else 
		{
			canMakeMove = true;		
		}	
		return canMakeMove;
	}

	public static void makeMove(char[][] board, char currentPlayerPiece, int row, int column) 
	{   
		if(currentPlayerPiece == 'X') 
		{
			board[row][column] = currentPlayerPiece;
		}
		else if(currentPlayerPiece == 'O') 
		{
			board[row][column] = currentPlayerPiece;
		}

	}
	public static boolean isBoardFull(char[][] board, int turn, boolean finished) 
	{
		boolean boardFull;

		if(turn == MAX_NO_OF_MOVES) 
		{
			boardFull = true;
		}
		else if(finished == true) 
		{
			boardFull = true;
		}
		else 
		{
			boardFull = false;	
		}
		return boardFull;
	}
	public static char winner(char[][]board, boolean finished) 
	{
		char winner = ' ';

		//check X
		if((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') || (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
				(board[2][0] == 'X' && board [2][1] == 'X' && board[2][2] == 'X') || (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
				(board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') || (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') || 
				(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') || (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')) 
		{
			finished = true;
			winner = 'X';
		}
		//check O
		else if((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') || (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||
				(board[2][0] == 'O' && board [2][1] == 'O' && board[2][2] == 'O') || (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
				(board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') || (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') || 
				(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') || (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')) 
		{
			finished = true;
			winner = 'O';
		}
		else
		{
			winner = 'D';
		}

		return winner;
	}
}
