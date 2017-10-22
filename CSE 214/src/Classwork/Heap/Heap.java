package Classwork.Heap;
public class Heap {
	
	//THIS IS A MAX HEAP JUST CHANGE ALL > TO < FOR MIN HEAP
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
		int position;
		if(isFull())
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			heapSize++;
			heapArr[heapSize-1] = d;
			position = heapSize-1;
			//This is for max heap for min heap change the > to <
			while(position > 0 && heapArr[position] > heapArr[(position-1)/2]){
				//checks if the new inserted data is larger than its parent at position (i-1)/2 with the new
				//data at i
				swap(position,(position-1)/2);
				position = (position -1)/2;
			}
		}
		
	}

	private void swap(int i, int j) {
		// TODO Auto-generated method stub
		int temp;
		temp = heapArr[i];
		heapArr[i] = heapArr[j];
		heapArr[j] = temp;
	}
	
	public int delete(){
		int answer;
		if(isEmpty()){
			System.out.println("IS EMPTY");
			return -1;
		}
		else{
			answer = heapArr[0];
			heapArr[0] = heapArr[heapSize -1];
			heapSize--;
			heapify();
			return answer;
		}
	}

	private void heapify() {
		// TODO Auto-generated method stub
		int pos = 0;
		int childPos;
		while(pos*2 +1 < heapSize){
			childPos = pos*2+1;
			if(childPos < heapSize -1 && heapArr[childPos +1] > heapArr[childPos])//For Min Heap just change the > to <
			{
				childPos++;
				//checking if the right child is greater than the left child
			}
			if(heapArr[pos] > heapArr[childPos])
				//For Min Heap just change the > to <
			{
				//checking if the parent or root is greater than its child
				return;
			}
			swap(pos, childPos);//swapping the parent and child if child is > than parent
			pos = childPos;
		}
	}
	
	public void print(){
		for(int i = 0; i< heapSize; i++)
		{
			System.out.print(heapArr[i] + " ");
		}
	}

}
