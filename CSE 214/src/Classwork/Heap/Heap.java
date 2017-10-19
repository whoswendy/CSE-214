package Classwork.Heap;
public class Heap {
	
	private int[] heapArr;
	private int heapSize;
	private int maxSize;
	
	public Heap(int max){
		if(max < 1 ) {
			maxSize = 100;
		}
		else{
			maxSize = max;			
		}
		heapArr = new int[maxSize];
		heapSize = 0;
	}
	
	public boolean isEmpty(){
		if(heapSize == 0)
			return true;
		else return false;
	}
	
	public boolean isFull(){
		if(heapSize == maxSize) return true;
		else return false;
	}
	
	public void insert(int d){
		
	}

}
