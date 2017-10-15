package Classwork.Stack;

public interface StackInterface<T> { //STACKS ARE FILO = First In Last Out = Dishes

	//checks if stack is empty
	public boolean isEmpty();
	
	//Inserts an item to the top of the stack
	public void push(T data) throws StackException;

	//Removes the item at the top of the stack and returns it
	public T pop() throws StackException;
	
	//Returns the item at the top of the stack
	public T peek() throws StackException;
}