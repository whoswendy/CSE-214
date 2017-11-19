package HW4.Question2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

/*CSE 214: Homework #4 HashTable
 * Question 2 
 * Wendy Hu
 * Student id#: 111560523
*/

public class Question2 {
	
	private static int trios;
	private static ArrayList<SumSet> triosArr = new ArrayList<SumSet>();
	private static ArrayList<SumSet> uniqueTrios = new ArrayList<SumSet>();


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
			}else{
				if(i == nums.length() -1)
				{
					temp += nums.charAt(i);
					arr.add(Integer.parseInt(temp));
				}
				else
					temp += nums.charAt(i);
			}
		}

		int size = arr.get(0);
		int target = arr.get(1);
		
		System.out.println("Size = "+size);
		System.out.println("Target = "+target);
	
		String inputs = in.nextLine();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		String temp2 = "";
		for(int i = 0; i< inputs.length(); i++)
		{
			if(inputs.charAt(i) == ' ')
			{
				arr2.add(Integer.parseInt(temp2));
				temp2 = "";
			}else{
				if(i == inputs.length() -1)
				{
					temp2 += inputs.charAt(i);
					arr2.add(Integer.parseInt(temp2));
				}
				else
					temp2 += inputs.charAt(i);
			}
		}
		
		Hashtable<Integer,ArrayList<Integer>> table = new Hashtable<Integer,ArrayList<Integer>>(size);
		Hashtable<Integer, Integer> freq = new Hashtable<Integer,Integer>(size);
		
		for(int i = 0; i< arr2.size(); i++){
			int num = 1;
			if(freq.containsKey(arr2.get(i))){
				System.out.println(""+arr2.get(i));
				num += 1;
			}
			freq.put(arr2.get(i), num);
		}

		//System.out.println(table.entrySet());
		//System.out.println(freq.entrySet());
		
		//1 10 4 3 2 5 0 1 9 5
		
		findTrios(freq,arr2,target);
		//System.out.println("Trios = "+trios);
		removeDuplicates();
		System.out.println("Trios = "+trios);
		
//		for(SumSet s: uniqueTrios)
//			s.print();
	}


	private static void removeDuplicates() {
		// TODO Auto-generated method stub
		for(SumSet s: triosArr){
			if(uniqueTrios.size() == 0){
				uniqueTrios.add(s);
			}else{
				int num = uniqueTrios.size();
				//System.out.println("num =" + num);
				int i = 0;
				boolean found  = false;
				while(i < num){
					if(uniqueTrios.get(i).equals(s)){
						found = true;
					}
					i++;
				}
				if(!found){
					uniqueTrios.add(s);
				}
			}
			
		}
		//System.out.println("Trios = " + uniqueTrios.size());
		trios = uniqueTrios.size();
	}


	private static void findTrios(Hashtable<Integer, Integer> table, ArrayList<Integer> arr, int target) {
		// TODO Auto-generated method stub
		for(int i = 0; i< arr.size(); i++){
			for(int j = i +1; j < arr.size(); j++)
			{
				int a = arr.get(i);
				int b = arr.get(j);
				int sum = a + b;
				if(sum % target == 0 && arr.contains(0)){
					if(a != 0 && b != 0){
						if(table.get(0) == 1){
							int c = 0;
							//System.out.println(a + " + " + b + "+" + c);
							trios++;
							SumSet set = new SumSet(a,b,c);
							triosArr.add(set);
						}
					}else{
						if(table.get(0) > 1){
							int c = 0;
							//System.out.println(a + " + " + b + "+" + c);
							trios++;
							SumSet set = new SumSet(a,b,c);
							triosArr.add(set);
						}
					}
				}
				else if(arr.contains(target - (sum % target))){
					int c = target - (sum % target);
					if((a != c && b != c) && table.get(c) >= 1){
						trios++;
						//System.out.println(a + " + " + b + "+" + c);
						SumSet set = new SumSet(a,b,c);
						triosArr.add(set);						
					}
					else if(a == c && b ==c && table.get(c) > 2){
						trios++;
						//System.out.println(a + " + " + b + "+" + c);
						SumSet set = new SumSet(a,b,c);
						triosArr.add(set);						
					}else if (((a == c && b != c) && table.get(c) > 1) || 
							(a != c && b == c) && table.get(c) > 1){
						trios++;
						//System.out.println(a + " + " + b + "+" + c);
						SumSet set = new SumSet(a,b,c);
						triosArr.add(set);	
					}

				}
			}
		}
		
	}
}
