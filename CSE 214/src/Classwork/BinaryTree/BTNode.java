package Classwork.BinaryTree;

public class BTNode{

	private int data;
	private BTNode left;
	private BTNode right;
	
	public BTNode(int newData){
		data = newData;
		left = null;
		right = null;
	}
	
	public int getData(){
		return data;
	}
	
	public void setData(int d){
		data = d;
	}
	
	public BTNode getLeft(){
		return left;
	}
	
	public void setLeft(BTNode newLeft){
		left = newLeft;
	}
	
	public BTNode getRight(){
		return right;
	}
	
	public void setRight(BTNode newRight){
		right = newRight;
	}
	

	
}
