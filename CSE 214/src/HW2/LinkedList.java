package HW2;

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
	private Node<T> curr;
	
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
			System.out.print("" + pos.data + " ");
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

	public void add(T data) {
		// TODO Auto-generated method stub
		Node<T> temp = head;
		while(temp.link != null)
		{
			temp = temp.link;
		}
		temp.link = new Node<T>(data,null);
		curr = temp.link;
	}

	public T get(int i) {
		// TODO Auto-generated method stub
		int pos = 0;
		Node<T> temp = head;
		while(temp != null)
		{
			if(pos == i)
				return temp.data;
			else{
				pos++;
				temp = temp.link;
			}
		}
		return null;
	}

	public void removeLast() {
		// TODO Auto-generated method stub
		if (curr.link == null) {
            Node<T> temp = head;
            while (temp.link != curr) {
                //System.out.println(temp.data);
                temp = temp.link;
            }
            temp.link = null;
            curr = head;
        }
	       
	}


	public void remove(int pos) {
		// TODO Auto-generated method stub
		Node<T> prev = head;
		Node<T> curr = head;
		
		if(pos == 0)
			deleteNodeHead();
		else if(pos == findLength()-1)
			removeLast();
		else if(pos > findLength()-1)
			System.out.println("Out of bound");
		else{
			int count = 0;
			while(count != pos && curr != null)
			{
				curr = curr.link;
				count++;
			}
			prev.link = curr.link;
			curr = null;
			//System.out.print("removed");			
		}
	}
}
