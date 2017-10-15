package HW2;

public class ListQueue {
	
	private Node top;
	private Node bottom;
	
	public ListQueue(){
		top = null;
		bottom = null;
	}
	
	private class Node {
		
		private int data;
		private Node link;
		
		
		public Node(int item, Node linkValue)
		{
			data = item;
			link = linkValue;
		}

	}

	public void enqueue(int d) {
		// TODO Auto-generated method stub
		Node old = bottom;
		bottom = new Node(d,null);

		if(isEmpty())
			top = bottom;
		else
			old.link = bottom;
	}

	public int dequeue() {
		// TODO Auto-generated method stub
		int item = top.data;
		top = top.link;
		if(isEmpty())
		{
			bottom = null;
		}
		return item;
		
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(top == null)
		{
			return true;
		}
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		Node pos = top;
		int count = 0;
		while(pos != null)
		{
			count++;
			pos = pos.link;
		}
		return count;
	}

	public int find(int num) {
		// TODO Auto-generated method stub
		Node pos = top;
		int count = 0;
		while(pos != null)
		{
			if(pos.data == num)
				return count;
			else{
				pos = pos.link;
				count++;
			}
		}
		return -1;
	}

}
