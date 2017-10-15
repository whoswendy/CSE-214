package Classwork.Queue;

public class ListQueue<T> implements QueueInterface<T>{
	
	private Node<T> top;
	private Node<T> bottom;
	
	public ListQueue(){
		top = null;
		bottom = null;
	}
	
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

	@Override
	public void enqueue(T d) {
		// TODO Auto-generated method stub
		Node old = bottom;
		bottom = new Node();
		bottom.data = d;
		bottom.link = null;
		if(isEmpty())
			top = bottom;
		else
			old.link = bottom;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		T item = top.data;
		top = top.link;
		if(isEmpty())
		{
			bottom = null;
		}
		return item;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(top == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		Node<T> pos = top;
		int count = 0;
		while(pos != null)
		{
			count++;
			pos = pos.link;
		}
		return count;
	}

}
