package HW4.Question1;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/*CSE 214: Homework #4 HashTable
 * Question 1 
 * Wendy Hu
 * Student id#: 111560523
*/

public class Question1 {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String nums = in.nextLine();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		String temp = "";
		for(int i = 0; i< nums.length(); i++)
		{
			if(nums.charAt(i) == ' ')
			{
				arr.add(Integer.parseInt(temp));
				temp = "";
			}else
				if(i == nums.length() -1)
				{
					temp += nums.charAt(i);
					arr.add(Integer.parseInt(temp));
				}
				else
					temp += nums.charAt(i);
		}

		int size = arr.get(0);
		int target = arr.get(1);
		
		String inputs = in.nextLine();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		String temp2 = "";
		for(int i = 0; i< inputs.length(); i++)
		{
			if(inputs.charAt(i) == ' ')
			{
				arr2.add(Integer.parseInt(temp2));
				temp2 = "";
			}else
				if(i == inputs.length() -1)
				{
					temp2 += inputs.charAt(i);
					arr2.add(Integer.parseInt(temp2));
				}
				else
					temp2 += inputs.charAt(i);
		}
		
		int n = size;
		int length = 0;
		while(n > 0){
			length += (n-1);
			n--;
		}
		
		Hashtable<Integer, Integer> table = new Hashtable<Integer,Integer>(length);
		
		boolean notFound = true;
		for(int i = 0; i< arr2.size(); i++){
			for(int j = i +1; j < arr2.size(); j++){
				table.put(arr2.get(i), arr2.get(j));
				if(found(table,arr2.get(i),target)){
					notFound = false;
					twoSums(i, j);
					return;
				}
			}
			table.remove(arr2.get(i));
		}
		if(notFound)
			System.out.println("[-1, -1]");
		
	}

	private static void twoSums(int i, int j) {
		// TODO Auto-generated method stub
		System.out.print("[" + i + "," + j + "]");
	}

	private static boolean found(Hashtable<Integer, Integer> table, int num, int target) {
		// TODO Auto-generated method stub
		if(table.get(num) + num == target)
			return true;
		return false;
	}
	

}
