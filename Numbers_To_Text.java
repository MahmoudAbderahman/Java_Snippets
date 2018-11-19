/** Number to text transformation application
 * 
 * 
 * Program to transfer numbers between -999,999,999 and 999,999,999 to text
 * 
 * @author Mahmoud_Abderahman
 * @version 2.0
 */
import java.util.*;
import java.lang.*;


public class Numbers_To_Text
{
	public static void main(String[] args)
	{
		String numberInput; // variable to hold the input as string (made specially for the minus thing)
		int numberAsInteger; // variable to hold the input after being parsed to integer
		String  result = ""; // variable to hold the result of the transformation process
		
		Scanner sc = new Scanner(System.in);

		// getting the user input
		System.out.print("Input: ");
		numberInput = sc.nextLine();

		// check if the first character minus, if it is true, then add the word "minus" and remove the minus symbol from the string
		if(numberInput.substring(0, 1).matches("-"))
		{
			result += "minus ";
			numberInput = numberInput.substring(1);
		}
		
		// getting the length of the input
		int length = (int)(Math.log10(Integer.parseInt(numberInput))) + 1;
 
		// parsing the variable to integer to be able to process it 
		numberAsInteger = Integer.parseInt(numberInput);
		
		// check if the number is zero
		if(numberAsInteger == 0)
		{
			System.out.println("zero");
		}
		
		// check if the number between hundred thousands and millions
		else if(length > 6 && length <= 9)
		{
			// divide the number into three numbers (hundred units), for example 123456789 will be divided to 123, 456 and 789
			// then applying the transform method to them
			int firstDigit = numberAsInteger / 1000000;
			result += (Transform(firstDigit) + " " + "million");
			int secondDigit = (numberAsInteger - (firstDigit * 1000000)) / 1000;
			int thirdDigit = (numberAsInteger - ((firstDigit * 1000000) + (secondDigit * 1000)));
			if(secondDigit > 0)
			{
				result = result + ", " + (Transform(secondDigit));
				result += " " + "thousand";
			}
			if(thirdDigit > 0)
			{
				result = result + ", " ;
				result = result + (Transform(thirdDigit));
			}
		}
		// check if the number between thousands and hundred thousands
		else if(length > 3 && length <= 6)
		{
			// divide the number into two numbers (hundred units), for example 123456 will be divided to 123 and 456
			// then applying the transform method to them
			int firstDigit = numberAsInteger / 1000;
			result += (Transform(firstDigit) + " " + "thousand");
			int secondDigit = (numberAsInteger - (firstDigit * 1000));
			if(secondDigit > 0)
			{
				result = result + ", " + (Transform(secondDigit));
			}
		}
		// check if the number between one and hundreds
		else if(length >= 1 && length <= 3)
		{
			result += (Transform(numberAsInteger));
		}
			System.out.println(result);
	}
	
	private static String Transform(int number)
	{	
		// create 3 different arrays to numbers from 1-9, 10-19, 20-90
		String[] numbersUntilTen = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] numbersUntilTwenty = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" }; 
		String[] otherNumbers = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		String res = ""; // variable to store the result, which will be returned after processing
		int firstDigit;
		
		// divide the whole number into two or three numbers, only if the number is greater or equal to 10
		if(number < 10)
		{
			firstDigit = number;
		}
		else
		{ 
			firstDigit = number / 100;
		}
		
		int secondDigit = number - (firstDigit * 100);
		int thirdDigit = secondDigit % 10;
		
		// avoid having problems when the second digit is zero
		if((number - (firstDigit * 100)) / 10 == 0)
		{
			secondDigit = 0;
		}
		
		
		if(firstDigit != 0 )
		{
			res = res + numbersUntilTen[firstDigit - 1];
			
			// add the word "hundred" only when the second digit is greater than or equal to 0
			if(secondDigit >= 0)
			{
				res += " hundred";
			}
		}
		
		// add the word "and" only if the number itself is greater than 100 and both second and third digits are greater than zero
		if ((secondDigit > 0 && number > 100) || (thirdDigit > 0 && number > 100))
		{
			res = res + " and ";
		}
		
		
		if(secondDigit > 0)
		{
			// handling the numbers between ten and nineteen
			if(secondDigit >= 10 && secondDigit <= 19)
			{
				res = res + numbersUntilTwenty[secondDigit - 10];
				return res;
			}
			
			// handling numbers between 20 and 99
			secondDigit /= 10;
			res = res + otherNumbers[(secondDigit) - 2];
			if(thirdDigit != 0)
				res += "-";
		}
		
		if (thirdDigit > 0)
		{
			res = res + numbersUntilTen[thirdDigit - 1];
		}
		return res;
	}
}
