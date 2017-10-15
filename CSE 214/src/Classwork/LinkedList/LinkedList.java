package Classwork.LinkedList;

public class LinkedList<T>{
	
	private class Node<T> {
		
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

	private Node<T> head;
	
	public LinkedList(){
		head = null;
	}
	
	public void addToStart(T itemData)
	{
		head = new Node<T>(itemData, head);
	}
	
	public boolean deleteNodeHead(){
		if(head == null)
		{
			return false;
		}
		else{
			head = head.link;
			return true;
		}
	}
	
	public int findLength(){
		int count = 0;
		Node<T> pos = head;
		while(pos != null)
		{
			count++;
			pos = pos.link;
		}
		return count;
	}
	
	public boolean contains(T item){
		return (find(item) != null);
	}

	private Node<T> find(T target) {
		// TODO Auto-generated method stub
		Node<T> pos = head;
		T itemAtPos;
		while(pos != null)
		{
			itemAtPos = pos.data;
			if(itemAtPos.equals(target))
			{
				return pos;
			}
			pos = pos.link;
		}
		return null;
	}
	
	public T findData(T target)
	{
		return find(target).data;
	}
	
	public void outPutList(){
		Node<T> pos = head;
		while(pos != null)
		{
			System.out.println("" + pos.data);
			pos = pos.link;
		}
	}
	
	public boolean isEmpty(){
		if(head == null)
		{
			return true;
		}
		else{
			return false;
		}
	}
	
	public void clear(){
		head = null;
	}
	
	public boolean equal(Object other){
		if(other == null)
		{
			return false;
		}
		else if (getClass() != other.getClass())
		{
			return false;
		}
		else{
			LinkedList<T> otherList = (LinkedList<T>)other;
			if(findLength() != otherList.findLength())
			{
				return false;
			}
			Node<T> pos = head;
			Node<T> otherPos = otherList.head;
			while(pos != null)
			{
				if(!(pos.data.equals(otherPos.data)))
				{
					return false;
				}
				pos = pos.link;
				otherPos = otherPos.link;
			}
			return true;
		}
	}
}
