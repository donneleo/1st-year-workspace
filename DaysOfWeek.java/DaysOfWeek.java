import javax.swing.JOptionPane;
import java.util.Scanner;

public class DaysOfWeek 
{
	public static final int DAYS_IN_APR_JUN_SEP_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMAL = 28;
	public static final int DAYS_IN_FEBRUARY_LEAP = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;


	public static void main(String[] args) 
	{
		try{String dateInput = JOptionPane.showInputDialog("Please enter a date in the format (day/month/year).");
		Scanner inputScanner = new Scanner(dateInput);
		inputScanner.useDelimiter("/");
		int day = inputScanner.nextInt();
		int month = inputScanner.nextInt();    
		int year = inputScanner.nextInt();      // taken from ValidDate.java sample on blackboard

		String dayOfTheWeek = dayOfTheWeek(day, month, year);
		String numberEnding = numberEnding(day);
		String monthName = monthName(month, year);


		if(isDateValid(day, month, year)) 
		{
			JOptionPane.showMessageDialog(null, dayOfTheWeek  + ", " + day + numberEnding + " " + monthName + " " + year);
		}else 
		{
			JOptionPane.showMessageDialog(null,  "This is not a valid date.", "Error", JOptionPane.ERROR_MESSAGE);
		}	
		}catch(NullPointerException exception) 
		{

		}catch(java.util.NoSuchElementException exception) 
		{
			JOptionPane.showMessageDialog(null, "No date entered.", "Error", JOptionPane.ERROR_MESSAGE); // exceptions checks taken from 
			                                                                                                 //ValidDate.java sample on blackboard
		}
	}
	public static String numberEnding (int day)
	{
		String numberEnding = "";

		if ((day == 11) || (day == 12) || (day == 13)) 
		{
			numberEnding = "th";
		}else 
		{
			switch(day % 10) 
			{
			case 1:
				numberEnding = "st";
				break;
			case 2:
				numberEnding = "nd";
				break;
			case 3:
				numberEnding = "rd";
				break;
			default:
				numberEnding = "th";
				break;
			}
		}
		return numberEnding;
	}

	public static String monthName(int month, int year) 
	{
		String monthIs = "";
		switch (month) 
		{
		case 1:
			monthIs = "January";
			break;
		case 2:
			monthIs = "February";
			break;
		case 3:
			monthIs = "March";
			break;
		case 4:
			monthIs = "April";
			break;
		case 5:
			monthIs = "May";
			break;
		case 6:
			monthIs = "June";
			break;
		case 7: 
			monthIs = "July";
			break;
		case 8:
			monthIs = "August";
			break;
		case 9:
			monthIs = "September";
			break;
		case 10:
			monthIs = "October";
			break;
		case 11: 
			monthIs = "November";
			break;
		case 12:
			monthIs = "Decmeber";
			break;
		}
		return(monthIs);
	}

	public static String dayOfTheWeek(int day, int month, int year) 
	{
		String dayOfTheWeek = "";
		if((month == 1) || (month == 2))
		{
			year = year - 1;
		}
		int firstTwoDigitsOfYear = (int)Math.floor(year / 100);
		int lastTwoDigitsOfYear = year % 100;
		int dayNumber = (int)Math.abs((day + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + lastTwoDigitsOfYear + 
				Math.floor(lastTwoDigitsOfYear/4)+ Math.floor(firstTwoDigitsOfYear/4) - (2*firstTwoDigitsOfYear)) % 7);

		switch (dayNumber) 
		{
		case 0:
			dayOfTheWeek = "Sunday";
			break;
		case 1:
			dayOfTheWeek = "Monday";
			break;
		case 2:
			dayOfTheWeek = "Tuesday";
			break;
		case 3:
			dayOfTheWeek = "Wednesday";
			break;
		case 4:
			dayOfTheWeek = "Thursday";
			break;
		case 5:
			dayOfTheWeek = "Friday";
			break;
		case 6:
			dayOfTheWeek = "Saturday";
			break;
		}
		return(dayOfTheWeek);
	}

	public static boolean isDateValid(int day, int month, int year) //taken from validDate program used in tutorial.
	{
		return ((day > 0) && (day <= daysInMonth(month, year)) && (month <= 12) && (month > 0) && (year > 0) && (year < 10000));	
	}
	public static int daysInMonth (int month, int year) 
	{
		int daysInMonth;

		switch(month) 
		{
		case 2:
			if(isLeapYear(year)) 
			{
				daysInMonth = DAYS_IN_FEBRUARY_LEAP;
			}else 
			{
				daysInMonth = DAYS_IN_FEBRUARY_NORMAL;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			daysInMonth = DAYS_IN_APR_JUN_SEP_NOV;
			break;
		default:
			daysInMonth = DAYS_IN_MOST_MONTHS;
			break;
		}
		return(daysInMonth);

	}
	public static boolean isLeapYear(int year) 
	{
		return (((year % 400 == 0) || (year % 4 == 0 )) && (year % 100 != 0));
	}

}
