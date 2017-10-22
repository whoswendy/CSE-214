package Classwork.Heap;

public class PriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap pQueue = new Heap(10);
		pQueue.insert(10);
		pQueue.print();
		System.out.println("");
		pQueue.insert(30);
		pQueue.print();
		System.out.println("");
		pQueue.insert(50);
		pQueue.print();
		System.out.println("");
		pQueue.delete();
		pQueue.print();

	}

}
