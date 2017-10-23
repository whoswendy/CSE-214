package Classwork.BTree;

public class BNode {
	
	public BNode left;
	public BNode right;
	private int data;
	private int height;
	
	public BNode(int n){
		left = null;
		right = null;
		data = n;
		height = 0;
	}
	
	public BNode getLeft(){
		return left;
	}
	
	public BNode getRight(){
		return right;
	}
	
	public void setLeft(BNode l){
		left = l;
	}
	
	public void setRight(BNode r){
		right = r;
	}
	
	public int getData(){
		return data;
	}
	
	public void setData(int d){
		data = d;
	}
	
	public void setHeight(int h){
		height = h;
	}
	
	public int getHeight(){
		return height;
	}
	

}
