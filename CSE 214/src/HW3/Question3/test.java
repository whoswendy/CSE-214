package HW3.Question3;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TwoThreeFourTree tree = new TwoThreeFourTree();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		
		for(int i = 0; i< arr.size(); i++)
		{
			tree.insert(arr.get(i));
		}
		tree.search(3);
	}

}
