package ExtraCredit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*CSE 214: Extra Credit Homework - Graphs
 * Question 1 
 * Wendy Hu
 * Student id#: 111560523
*/

public class Homework {
	
	private static int trials = 0;
	private static int cases;
	
	public static void main(String[] args) throws FileNotFoundException{
			
		Scanner input = new Scanner(new File("C:\\Users\\huwen\\Desktop\\in1.txt"));//INSERT FILE NAME HERE!
		
		cases = Integer.parseInt(input.nextLine());
		
		while(trials < cases){
			int n = Integer.parseInt(input.nextLine());
			Graph matrix = new Graph(n);
			
			String line = input.nextLine();
			ArrayList<String> arr = new ArrayList<String>();
			String s = "";
			for(int i = 0; i< line.length(); i++){
				if(line.charAt(i) == ' '){
					arr.add(s);
					s = "";
				}else{
					if(i == line.length() -1){
						s += line.charAt(i);
						arr.add(s);
					}else
						s += line.charAt(i);
				}
			}
			
			int source = Integer.parseInt(arr.get(0));
			int destination = Integer.parseInt(arr.get(1));
			
			for(int row = 0; row < n; row++){
				String stringTemp = input.nextLine();
				String temp = "";
				ArrayList<String> tempArr = new ArrayList<String>();
				for(int i = 0; i< stringTemp.length(); i++)
				{
					if(stringTemp.charAt(i) == ' ')
					{
						tempArr.add(temp);
						temp = "";
					}else
						if(i == stringTemp.length() -1)
						{
							temp += stringTemp.charAt(i);
							tempArr.add(temp);
						}
						else{
							temp += stringTemp.charAt(i);
						}
				}

				int col = 0;
				for(int i = 0; i< tempArr.size(); i++){
					//if(tempArr.get(i) != "0"){
						//System.out.println("i=" + tempArr.get(i));
						int weight = Integer.parseInt(tempArr.get(i));
						matrix.addEdge(row, col, weight);
					//}
					col++;
				}
			}
			
			//matrix.printGraph();
			matrix.dijkstra_algor(source, destination);
			System.out.println("");
			trials++;
		}
	
	}
	
	
}
