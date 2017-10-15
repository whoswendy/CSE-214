package HW2.Question3;
/*CSE 214: Homework #2 Linked List, Stack and Queues
 * Question 3
 * Wendy Hu
 * Student id#: 111560523
*/

public class LeakyStack<T>{

	private String[] stack;
	private int head;
	private int tail;

	
	public LeakyStack(int capacity){
		stack = new String[capacity];
		head = 0;
//		tail = capacity;
	}
	
	public void push(String s)
	{	
		for(int i = stack.length-1; i>0; i--)
		{
			stack[i] = stack[i-1];
		}
		//print();
		stack[head] = s;
	}
	
//	public void push(String s){
//		if(tail == head)
//		{
//			tail = stack.length;
//		}
//		tail--;
//		stack[tail] = s;
//	}
	
	public String pop(){
		String temp = stack[head];
		stack[head] = "";
		for(int i = 0; i< stack.length-1; i++)
		{
			stack[i] = stack[i+1];
		}
		stack[stack.length-1] = "";
		return temp;
	}

	
	public void print(){
		for(int i = 0; i< stack.length; i++)
		{
			System.out.print(stack[i] + " ");
		}
	}
}
