package HW3.Question1;
/*CSE 214: Homework #3 Binary Search Tree, Heap, 2-3-4 Tree
 * Question 1
 * Wendy Hu
 * Student id#: 111560523
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String numOfNodes;
		System.out.println("Please insert the value N, the number of nodes");
		numOfNodes = in.nextLine();
		System.out.println("Please insert the values of the nodes");
		String datas;
		datas = in.nextLine();
		
		ArrayList<Integer> data = new ArrayList<Integer>();
		String temp = "";
		for(int i = 0; i< datas.length(); i++){
			if(datas.charAt(i) == ' ' ){
				data.add(Integer.parseInt(temp));
				temp = "";
			}else if(i == datas.length() -1){
				temp += datas.charAt(i);
				data.add(Integer.parseInt(temp));
			}
			else
			{
				temp += datas.charAt(i);
			}
		}
		
		
		BinaryTree tree = new BinaryTree(numOfNodes);
		for(int i = 0; i< data.size(); i++){
			tree.insert(data.get(i));
		}
		//tree.inorder();
		tree.changeToBST();
	}
}
