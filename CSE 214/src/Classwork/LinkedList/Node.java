package Classwork.LinkedList;

public class Node<T> {
	
	private T data;
	private Node<T> link;
	
	public Node(){
		data = null;
		link = null;
	}
	
	public Node(T item, Node<T> linkValue)
	{
		data = item;
		link = linkValue;
	}


}
