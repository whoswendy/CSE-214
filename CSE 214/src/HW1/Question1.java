package HW1;
/*CSE 214: Homework #1 Complexity Analysis and Abstract Data Types
 * Question 1a and 1b
 * Wendy Hu
 * Student id#: 111560523
*/
public class Question1 {
	
	public static void main(String[] args){
		
		int[] array1 = {11,15,6,8,9,10};
		problem1A(array1,16);//returns the outputs that adds up to 16 and true
		problem1A(array1,27);//returns false
		problem1B(array1,25);//returns the outputs that adds up to 25 and true
		problem1B(array1,39);//returns false
		
	}
	/*1. Complexity Analysis:
	a. Write a short Java program that takes an array of int values as input and find if there is a pair
	of numbers with a given sum. What is the total number of operations that occur in terms of
	input size n in closed form for worst case scenario. What is the time complexity in Big
	O-notation?*/
	//Adding each number and the numbers after it to see if the two numbers equal the target
	public static boolean problem1A(int[] arr, int target){
		boolean pair = false;
		int a;
		int b;
		for(int i = 0; i< arr.length; i++)
		{
			a = arr[i];
			for(int j = i+1; j< arr.length; j++)
			{
				b = arr[j];
				if(a+b == target)
				{
					pair = true;
					System.out.println("" + a + " + " + b + " = " + target + " , " + pair);
					return pair;
				}
			}
		}
		System.out.println("" + pair);
		return pair;
	}
	
	/*b. Write a short Java program that takes an array of int values as input and find if there is a
	triplet of numbers with a given sum. What is the total number of operations that occur in
	terms of input size n in closed form for worst case scenario. What is the time complexity in
	Big O-notation?*/
	//Adding each number and the numbers after it to see if the three numbers equal the target
	public static boolean problem1B(int[]arr, int target){
		boolean triple = false;
		int a;
		int b;
		int c;
		for(int i = 0; i< arr.length; i++)
		{
			a= arr[i];
			for(int j = i +1; j<arr.length; j++)
			{
				b=arr[j];
				for(int k = j+1; k<arr.length; k++)
				{
					c= arr[k];
					if(a+b+c == target)
					{
						triple = true;
						System.out.println(""+a+" + " + b + " + " + c + " = " + target + " , " + triple);
						return triple;
					}
				}
			}
		}
		System.out.println("" + triple);
		return triple;
		
	}

}

