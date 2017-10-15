package HW2.Question2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import HW2.LinkedList;

/*CSE 214: Homework #2 Linked List, Stack and Queues
 * Question 2
 * Wendy Hu
 * Student id#: 111560523
*/

public class Question2 {

	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("in2.txt"));//This is where the location of the file needs to be inserted
		
		while(input.hasNextLine()){
			
			String testNumber = input.nextLine();
			System.out.println("Testcase "+ testNumber);
			
			ArrayList<String> stringsTemp1 = new ArrayList<String>();
			String temp;
			
			temp = input.nextLine();
			
			String element = "";
			for(int i = 0; i< temp.length(); i++)
			{
				if(temp.charAt(i)==' '){
					stringsTemp1.add(element);
					element = "";
				} 
				else if(i == temp.length()-1 && !(temp.charAt(i)==' ')){
					stringsTemp1.add(""+temp.charAt(temp.length()-1));
				}
				else
					element += temp.charAt(i);
			}
			
			int[] players = new int[stringsTemp1.size()];
			for(int i = 0; i< stringsTemp1.size(); i++)
			{
				players[i] = Integer.parseInt(stringsTemp1.get(i));
				//System.out.print(" " + players[i]);
			}
			
			ArrayList<String> stringsTemp2 = new ArrayList<String>();
			String temp2;
			
			temp2 = input.nextLine();
			String element2 = "";
			for(int i = 0; i< temp2.length(); i++)
			{
				if(temp2.charAt(i)==' '){
					stringsTemp2.add(element);
					element = "";
				}
				else
					element += temp2.charAt(i);
			}
			
			
			int[] heights = new int[stringsTemp2.size()];
			for(int i = 0; i< stringsTemp2.size(); i++)
			{
				heights[i] = Integer.parseInt(stringsTemp2.get(i));
				//System.out.print(" " + heights[i]);
			}
			
			//int[] player = new int[]{1,2, 3, 4, 5, 6, 7};
			//int[] heights = new int[]{177, 175, 165, 172, 161, 170, 164};
			
			deList(players,heights);
			System.out.println("");
		}
		input.close();
	}
	
	public static void deList(int[] players, int[] heights){
		LinkedList<Integer> in = new LinkedList<Integer>();

		for(int i = 0; i< players.length; i++)
		{
			if(in.isEmpty())
			{
				in.addToStart(players[i]);
			}
			else{
				in.add(players[i]);	
			}
			if(i+1 < players.length && i+1 < heights.length && heights[i] < heights[i+1])
			{
				in.removeLast();
			}
		}
		in.outPutList();

	}
}
