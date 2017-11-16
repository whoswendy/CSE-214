package HW4.Question1;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/*CSE 214: Homework #4 HashTable
 * Question 1 
 * Wendy Hu
 * Student id#: 111560523
*/

public class Question1B {
	
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
		
		Hashtable<Integer, ArrayList<Integer>> table = new Hashtable<Integer,ArrayList<Integer>>(length);
		Hashtable<Integer, Integer> freq = new Hashtable<Integer,Integer>(length);
		
		for(int i = 0; i< arr2.size(); i++){
			int num = 1;
			if(freq.containsKey(arr2.get(i))){
				System.out.println(""+arr2.get(i));
				num += 1;
			}
			freq.put(arr2.get(i), num);
		}
		System.out.println(freq.entrySet());
		
		for(int i = 0; i< arr2.size();i++){
			ArrayList<Integer> pos = new ArrayList<Integer>();
			pos.add(i);
			table.put(arr2.get(i),pos);
		}
		
		for(int i = 0; i< arr2.size(); i++){
			if(freq.get(arr2.get(i)) > 1){
				ArrayList<Integer> tempArr = table.get(arr2.get(i));
				if(!tempArr.contains(i))
					tempArr.add(i);
				table.put(arr2.get(i), tempArr);
			}
		}
		
		System.out.println(table.entrySet());
		
		findIndices(table,freq,arr2, target);


	}

	private static void findIndices(Hashtable<Integer, ArrayList<Integer>> table, Hashtable<Integer, Integer> freq,
			ArrayList<Integer> arr, int target) {
		// TODO Auto-generated method stub
		int[] indices = {-1,-1};
		for(int i = 0; i<arr.size(); i++){
			int a = arr.get(i);
			int num = target - a;
			if(a == num && freq.containsKey(a) && freq.get(a) > 1){
				if(table.get(a).get(0) > table.get(a).get(1)){
					indices[0] = table.get(a).get(1);
					indices[1] = table.get(a).get(0);
					System.out.println("[" + indices[0] + "," + indices[1] + "]");
					return;
				}else{
					indices[0] = table.get(a).get(0);
					indices[1] = table.get(a).get(1);		
					System.out.println("[" + indices[0] + "," + indices[1] + "]");
					return;
				}
			}
			else if(table.containsKey(num)){
				int b = table.get(num).get(0);
				if(b > i){
					indices[0] = b;
					indices[1] = i;
					System.out.println("[" + indices[0] + "," + indices[1] + "]");
					return;
				}
				else{
					indices[0] = i;
					indices[1] = b;
					System.out.println("[" + indices[0] + "," + indices[1] + "]");
					return;
				}
			}
		}
		System.out.println("[" + indices[0] + "," + indices[1] + "]");
	}
}
