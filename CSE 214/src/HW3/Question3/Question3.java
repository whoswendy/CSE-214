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
		
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			String temp = in.nextLine();
			ArrayList<Integer> tempArr = new ArrayList<Integer>();
			String tempStr = "";
			for(int i = 0; i< temp.length(); i++){
				if(temp.charAt(i) == ' ')
				{
					tempArr.add(Integer.parseInt(tempStr));
					tempStr = "";
				}else
					if(i == temp.length() -1)
					{
						tempStr += temp.charAt(i);
						tempArr.add(Integer.parseInt(tempStr));
					}
					else
						tempStr += temp.charAt(i);
			}
			
			TwoThreeFourTree tree = new TwoThreeFourTree();
			if(tempArr.get(0) == 1){
				System.out.println(""+tempArr.get(1));
				int key = tempArr.get(1);
				tree.insert(key);
			}
			else if(tempArr.get(0) == 2){
				System.out.println("Sorry but do not have delete function");
			}
			else if(tempArr.get(0) == 3){
				System.out.println(""+tempArr.get(1));
				int key = tempArr.get(1);
				tree.search(key);
			}
			else if(tempArr.get(0) == 4 || tempArr.get(0) == 5 || tempArr.get(0) == 6 ){
				System.out.println("Sorry but do not have traversal function");
			}

		}
	}

}
