package HW3.Question3;

import java.util.ArrayList;
import java.util.Scanner;

/*CSE 214: Homework #3 Binary Search Tree, Heap, 2-3-4 Tree
 * Question 3 for extra credit
 * Wendy Hu
 * Student id#: 111560523
*/

public class Question3 {
	
	public static void main(String[] args){
		
		TwoThreeFourTree tree = new TwoThreeFourTree();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the operation 1 for insertion and 3 for search, delete and traversal does not work");
		while(in.hasNextLine()){
			String enter = in.nextLine();
			System.out.println("Please enter the number to be inserted or searched");
			String num = in.nextLine();
			
			if(enter.equals("1")){
				tree.insert(Integer.parseInt(num));
				System.out.println(num + " was inserted");
			}
			else if(enter.equals("2")) System.out.println("Sorry but no delete function");
			else if(enter.equals("3")) tree.search(Integer.parseInt(num));
			else if(enter.equals("4") || enter.equals("5") || enter.equals("6") ) 
				System.out.println("Sorry but no traversal function");
			
			System.out.println("Please enter the operation 1 for insertion and 3 for search, delete and traversal does not work");
		}
	}
}
