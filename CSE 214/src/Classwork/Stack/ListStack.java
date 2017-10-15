package Classwork.Stack;

public class ListStack<T> implements StackInterface<T>{
	
	private Node<T> top;
	
	public ListStack(){
		top = null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(top == null)
		{
			return true;
		}
		else return false;
	}

	@Override
	public void push(T data) {
		// TODO Auto-generated method stub
		top = new Node<T>(data,top);
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new StackException("Stack is Empty");
		}
		T data = top.data;
		top = top.next;
		return data;
	}

	@Override
	public T peek(){
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new StackException("Stack is Empty");
		}
		return top.data;
	}
	
	private class Node<T> {
		
		public T data;
		public Node<T> next;
		
		public Node(){
			data = null;
			next = null;
		}
		
		public Node(T item, Node<T> linkValue)
		{
			data = item;
			next = linkValue;
		}

	}	

}
