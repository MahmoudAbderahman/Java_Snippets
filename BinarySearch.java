/** Binary search application
 * 
 * 
 * implementing the binary search using the recursion method. The user is asked to give number of elements in order
 * and give a certain number to test with, then the index of this element is returned
 * 
 * @author Mahmoud_Abderahman
 * @version 1.0
 */
import java.util.*;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args)
	{
		int n, ele, result; // create 3 variables for the number of elements, the element that the user is looking for and the return value of the method
		List<Integer> ints = new ArrayList<Integer>(); // create a new list to hold the elements, we are searching in
		
		Scanner sc = new Scanner(System.in);
		
		// ask the user, how many elements are there in the array and get the number from the user
		System.out.print("How many elements are there in the array? ");
		n = sc.nextInt();
		
		System.out.println("Please give me the elements sorted: ");
		
		// get the elements of the list from the user
		for(int i = 0; i < n; i++)
		{
			System.out.print(i + 1 + "st element: ");
			ints.add(sc.nextInt());
		}
		
		
		// ask the user about the element, that he wants to test
		System.out.print("Which number do you want to test with the binary search method? ");
		ele = sc.nextInt();
		
		// call the binary search method and store the returned value in a variable
		result = binarySearch(ints, 0, n - 1, ele);
		
		// the element was not found
		if(result == -1)
		{
			System.out.println("The element is not found!");
		}
		// the element was found, and we get back the index of it
		else
		{
			System.out.println("Element found in the index " + result);
		}
	}
	public static int binarySearch(List<Integer> arr, int begin, int end, int ele)
	{
		
		if(end >= 1) // if the range is one or greater (2 elements or more)
		{
			int mid = begin + (end - begin) / 2; // finding the middle element
			
			if(ele == arr.get(mid)) return mid; // if the element was the one in the middle, then we return the index
			
			else if(ele > arr.get(mid)) // when the element is greater than the element in the middle, that means we should look in the right half
			{
				return binarySearch( arr, mid + 1, end, ele);
			}
			
			return binarySearch(arr, begin, mid - 1, ele); // when the element is greater than the element in the middle, that means we should look in the right half
		}
		
		return -1; // returning -1 means that the element was not found
	}
}
