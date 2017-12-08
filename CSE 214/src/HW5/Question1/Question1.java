package HW5.Question1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*CSE 214: Homework #5 Graph
 * Question 1 
 * Wendy Hu
 * Student id#: 111560523
*/

public class Question1 {
	
	private static int trials = 0;
	private static int cases;
	private static int numPaths;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("C:\\Users\\huwen\\Desktop\\in1.txt"));//INSERT FILE NAME HERE!
		cases = Integer.parseInt(input.nextLine());
		
		//System.out.println("" + cases);
		
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
			//printMatrix(matrix);
			findRoute(matrix);
			System.out.println(""+numPaths);
			trials++;
			//System.out.println("");
		}

		
	}

	private static void findRoute(int[][] matrix) {
		// TODO Auto-generated method stub
		numPaths = 0;
		int n = matrix.length;
		if(matrix[0][0] == 1 || matrix[n-1][n-1] == 1){
			System.out.println(""+numPaths);
			return;
		}else{
			countPath(matrix);
			//findPaths(matrix, 0, 0, numPaths); does not work :(
			//System.out.println(""+numPaths); 

		}
	}

	private static void findPaths(int[][] matrix, int i, int j, int numPaths2) {
		// TODO Auto-generated method stub
		int n = matrix.length;
		if(i == n-1 && j == n-1){
			numPaths++;
		}
		else if(i < n-1 && matrix[i][j] != 1){
			findPaths(matrix, i +1, j, numPaths);
		}
		else if(i > 0 && matrix[i][j] != 1){
			findPaths(matrix, i-1, j, numPaths);
		}
		else if(j > 0 && matrix[i][j] != 1){
			findPaths(matrix, i, j -1, numPaths);
		}
		else if(j < n-1 && matrix[i][j] != 1){
			findPaths(matrix, i, j + 1, numPaths);
		}else{
			return;
		}

	}

	private static void countPath(int[][] matrix) {
		// TODO Auto-generated method stub
		int n = matrix.length;
		
		//checks 1st row
		for(int i = 0; i<n; i++){
			if(matrix[0][i] == 0){
				matrix[0][i] = 1;
			}else
				break;
		}
		//printMatrix(matrix);
		
		//checks 1st col
		for(int j = 1; j< n; j++){
			if(matrix[j][0] == 0){
				matrix[j][0] = 1;
			}else
				break;
		}
		//printMatrix(matrix);
		
		
		for(int i = 1; i< n; i++){
			for(int j = 1; j< n; j++){
				if(matrix[i][j] == -1){
					continue;
				}
				
				if(matrix[i-1][j] >= 0){
					matrix[i][j] = (matrix[i][j] + matrix[i-1][j]);
					//printMatrix(matrix);
				}
				
				if(matrix[i][j-1] >= 0){
					matrix[i][j] = (matrix[i][j] + matrix[i][j-1]);
					//printMatrix(matrix);
				}
			
			}
		}
		
		numPaths = matrix[n-1][n-1];
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
