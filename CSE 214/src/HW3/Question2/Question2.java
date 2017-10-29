package HW3.Question2;
/*CSE 214: Homework #3 Binary Search Tree, Heap, 2-3-4 Tree
 * Question 2
 * Wendy Hu
 * Student id#: 111560523
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int numRows;
		int numFans;
		System.out.println("Please enter M, the number of seating rows and N, the number of fans");
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
		numRows = arr.get(0);
		numFans = arr.get(1);

		
		System.out.println("Please enter the number of seats in each row");
		String data = in.nextLine();

		ArrayList<Integer> seats = new ArrayList<Integer>();
		String temp2 = "";
		for(int i = 0; i< data.length(); i++)
		{
			if(data.charAt(i) == ' ')
			{
				seats.add(Integer.parseInt(temp2));
				temp2 = "";
			}else
				if(i == data.length() -1)
				{
					temp2 += data.charAt(i);
					seats.add(Integer.parseInt(temp2));
				}
				else
					temp2 += data.charAt(i);
		}
		
		int totalCost = 0;
		Heap sellingSeats = new Heap(seats.size());
		for(int i = 0; i< seats.size(); i++){
			sellingSeats.insert(seats.get(i));
		}
		sellingSeats.print();
		while(numFans > 0){
			int cost = sellingSeats.delete();
			totalCost += cost;
			sellingSeats.insert(cost-1);
			numFans--;
		}
		System.out.println("Total cost = " + totalCost);

	}

}
