package HW2.Question3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*CSE 214: Homework #2 Linked List, Stack and Queues
 * Question 3
 * Wendy Hu
 * Student id#: 111560523
*/

public class Question3 {
	private static int capacity;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("in3.txt"));//This is where the location of the file needs to be inserted
		
		while(input.hasNextLine()){
			
			String testCase = input.nextLine();//Takes the first line int as the test number
			System.out.println("Testcase " + testCase);
			String temp = input.nextLine();
			capacity = Integer.parseInt(temp);//Takes the second line int as the capacity of the LeakyStack
			
			ArrayList<String> stringTemp = new ArrayList<String>();
			String temp2 = input.nextLine();
			String element = "";
			for(int i = 0; i<temp2.length();i++)
			{
				if(temp2.charAt(i) == ' ')
				{
					stringTemp.add(element);
					element = "";
				}
				else{
					if(i == temp2.length()-1)
					{
						element += temp2.charAt(i);
						stringTemp.add(element);
					}
					else
						element += temp2.charAt(i);
				}
				
			}
			
			LeakyStack stackTest = new LeakyStack(capacity);//Creates a new LeakyStack with the test capacity
			
			for(int i = 0 ; i < stringTemp.size(); i++)
			{
				stackTest.push(stringTemp.get(i));
			}
			stackTest.print();
			System.out.println("");
	}
	
}
	

}
