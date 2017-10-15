package Classwork.Queue;

public interface QueueInterface<T>{
	
	public void enqueue(T data);
	
	public T dequeue();
	
	public boolean isEmpty();
	
	public int size();

}
