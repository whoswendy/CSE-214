package Classwork.BinaryTree;

public class Testing {
	
	public static void main(String[] args){
		
		BinarySearchTree testTree = new BinarySearchTree(50);
		testTree.insert(20);
		testTree.insert(80);
		testTree.inorder();
	}

}
