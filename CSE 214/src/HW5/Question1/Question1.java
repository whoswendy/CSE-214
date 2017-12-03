package HW5.Question1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*CSE 214: Homework #5 Graph
 * Question 1 
 * Wendy Hu
 * Student id#: 111560523
*/

public class Question1 {
	
	private static int trials = 0;
	private static int cases;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("C:\\Users\\huwen\\Desktop\\in1.txt"));
		cases = Integer.parseInt(input.nextLine());
		
		System.out.println("" + cases);
		
		while(trials < cases){
			int n = Integer.parseInt(input.nextLine());
			int[][] matrix = new int[n][n];
			//printMatrix(matrix);	
			for(int row = 0; row < n; row++){
				String line = input.nextLine();
				String temp = "";
				for(int i = 0; i< line.length(); i++){
					if(line.charAt(i) != ' ' ){
						temp += line.charAt(i);
					}
				}
				int col = 0;
				for(int i = 0; i< temp.length(); i++){
					if(temp.charAt(i) == '1'){
						matrix[row][col] = 1;
					}
					col++;
				}
			}
			printMatrix(matrix);
			findRoute(matrix);
			trials++;
			System.out.println("");
		}

		
	}

	private static void findRoute(int[][] matrix) {
		// TODO Auto-generated method stub
		
	}

	private static void printMatrix(int[][] matrix) {
		// TODO Auto-generated method stub
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(""+matrix[i][j]);
			}
			System.out.println("");
		}
	}

}
