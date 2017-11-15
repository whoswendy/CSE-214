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
		
		for(int i = 0; i< arr2.size(); i++){
			if(!table.containsKey(arr2.get(i)))
				table.put(arr2.get(i), i);//{key,element} key = num element = index
		}
		
		findIndices(table,arr2,target);
			
	}

	private static void findIndices(Hashtable<Integer, Integer> table, ArrayList<Integer> arr, int target) {
		// TODO Auto-generated method stub
		for(int i = 0; i< arr.size(); i++){
			int temp = arr.get(i);
			int secondNum = target - temp;
			if(table.containsKey(secondNum))
			{
				int b = table.get(secondNum);
				if(temp > secondNum){
					System.out.println("["+b+","+i+"]");
					return;
				}else{
					System.out.println("["+i+","+b+"]");
					return;
				}
			}
		}
		System.out.println("[-1,-1]");
	}

	

}
