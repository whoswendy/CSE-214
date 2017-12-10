package ExtraCredit;

/*CSE 214: Extra Credit Homework - Graphs
 * Question 1 class
 * Wendy Hu
 * Student id#: 111560523
*/

import java.util.ArrayList;

import java.util.Hashtable;

public class Graph {
	
	private int size;
	private int[][] matrix;
	private ArrayList<Integer> path = new ArrayList<Integer>();
	
	public Graph(int n){
		size = n;
		matrix = new int[n][n];
	}
	
	public int getSize(){
		return size;
	}
	
	public void addEdge(int from, int to, int weight){
		//if(to > size) System.out.println("WHYYYY");
		matrix[from][to] = weight;
	}
	
	public int getEdge(int from, int to){
		return matrix[from][to];
	}
	
	public void dijkstra_algor(int source, int destination){
		int[] distance = new int[size];
		int[] parent = new int[size];
		parent[0] = -1;
		Hashtable<Integer,Integer> vMinusS = new Hashtable<Integer,Integer>(size);
		
		for(int i = 0; i< size; i++)
			distance[i] = 1000; //using 1000 = infinity
		distance[source] = 0;
		
		for(int i = 0; i < size; i++)
			vMinusS.put(i,distance[i]);
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		
		for(int i = 0; i< size; i++){
			int next = findMin(distance,vMinusS);
			//System.out.println("next" + next);
			if(!s.contains(next))
				s.add(next);
			vMinusS.remove(next);
			
			ArrayList<Integer> neighbors = new ArrayList<Integer>();
			for(int j = 0; j < size; j++){
				if(vMinusS.containsKey(j)){
					if(matrix[next][j] > 0){
						neighbors.add(j);
					}
				}
			}
			
			for(int v: neighbors){
				if(distance[next] + getEdge(next,v) < distance[v]){
					distance[v] = distance[next] + getEdge(next,v);
					vMinusS.put(v,distance[v]);
					parent[v] = next;
				}
			}
		}
		//print(distance);
		System.out.println(distance[destination]);
		if(distance[destination] != 0){
			path.add(source);
			printPath(parent,destination);	
			path.add(destination);
			printPath(path);
		}else{
			System.out.println("No path found");
		}
	}
	
	private void printPath(ArrayList<Integer> path) {
		// TODO Auto-generated method stub
		for(int i=0; i< path.size()-1;i++ )
		{
			if(i != path.size() -2)
				System.out.print(path.get(i)+"->");
			else
				System.out.print(path.get(i)+"");
		}
	}

	private void printPath(int[] parent, int destination) {
		// TODO Auto-generated method stub
		if(parent[destination] == -1)
			return;
		printPath(parent,parent[destination]);
		
		path.add(destination);
		//System.out.print(destination+" ");
	}

	private void print(int[] distance) {
		// TODO Auto-generated method stub
		for(int i = 0; i<distance.length;i++)
			System.out.println(""+i+"="+distance[i]);
	}

	private int findMin(int[] distance, Hashtable<Integer, Integer> vMinusS) {
		// TODO Auto-generated method stub
		int min = 100000;//a really big num
		int index = -1;
		for(int i = 0; i< size; i++){
			if(distance[i] < min && vMinusS.containsKey(i)){
				min = distance[i];
				index = i;
			}
		}
		return index;
	}


	public void printGraph(){
		for(int i = 0; i < size; i++){
			for(int j = 0; j< size; j++){
				System.out.print(""+matrix[i][j]);
			}
			System.out.println("");
		}
	}

}
