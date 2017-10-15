package HW2.Question4;
/*CSE 214: Homework #2 Linked List, Stack and Queues
 * Question 4
 * Wendy Hu
 * Student id#: 111560523
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import HW2.ListQueue;

public class Question4 {

	private static ListQueue original;
	private static ListQueue newQueue;
	private static int num;
	private static int iteration;
	private static int it2;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("in4.txt"));//This is where the location of the file needs to be inserted
		
		while(input.hasNextLine()){
			String testCase = input.nextLine();
			System.out.println("Testcase " + testCase);
			
			String tempString1 = input.nextLine();
			ArrayList<String> tempArr = new ArrayList<String>();
			String temp = "";
			for(int i = 0; i< tempString1.length(); i++)
			{
				if(tempString1.charAt(i) == ' ')
				{
					tempArr.add(temp);
					temp = "";
				}
				else{
					if(i == tempString1.length()-1){
						temp += tempString1.charAt(i);
						tempArr.add(temp);
					}else
						temp += tempString1.charAt(i);
				}
			}
			num = Integer.parseInt(tempArr.get(0));
			iteration = Integer.parseInt(tempArr.get(1));
			
			String tempString2 = input.nextLine();
			ArrayList<String> tempArr2 = new ArrayList<String>();
			String temp2 = "";
			for(int i = 0; i< tempString2.length(); i++)
			{
				if(tempString2.charAt(i) == ' ')
				{
					tempArr2.add(temp2);
					temp2 = "";
				}else
				{
					temp2 += tempString2.charAt(i);
				}
			}

			
			int[] arr = new int[tempArr2.size()];
			for(int i = 0; i< tempArr2.size();i++)
			{
				arr[i] = Integer.parseInt(tempArr2.get(i));
			}
			
			original = new ListQueue();
			newQueue = new ListQueue();
			
			addToQueue(arr);
			
			for(int i = 0; i < iteration; i++)
			{
				System.out.print(""+selection());
			}
			System.out.println("");
		}


	}

	private static int selection() {
		// TODO Auto-generated method stub

		ArrayList<Integer> temp = new ArrayList<Integer>();
		int max;
		
		for(int i = 0; i<iteration; i++)
		{	
			if(!newQueue.isEmpty())
			temp.add(newQueue.dequeue());
		}
		max = findMax(temp);
		
		for(int i = 0; i< temp.size();i++)
		{
			if(temp.get(i) == max)
			{
				temp.remove(i);
				break;
			}
		}
		
		int answer = original.find(max);
		for(int i = 0; i< temp.size(); i++){
			newQueue.enqueue(temp.get(i));
		}
		//System.out.println("" + max);
		return answer;
		
	}

	private static int findMax(ArrayList<Integer> temp) {
		// TODO Auto-generated method stub
		int max = -1;
		for(int i = 0; i<temp.size(); i++)
		{
			if(temp.get(i) > max && temp.get(i) != max)
				max = temp.get(i);
		}
		//System.out.println("" + max);
		return max;
	}

	private static void addToQueue(int[] b) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<b.length; i++)
		{
			original.enqueue(b[i]);
			newQueue.enqueue(b[i]);
		}
	}
}
