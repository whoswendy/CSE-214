package HW3.Question1;

import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String numOfNodes;
		System.out.println("Please insert the value N, the number of nodes");
		numOfNodes = in.nextLine();
		System.out.println("Please insert the values of the nodes");
		String datas;
		datas = in.nextLine();
		
		ArrayList<Integer> data = new ArrayList<Integer>();
		String temp = "";
		for(int i = 0; i< datas.length(); i++){
			if(datas.charAt(i) == ' ' ){
				data.add(Integer.parseInt(temp));
				temp = "";
			}else if(i == datas.length() -1){
				temp += datas.charAt(i);
				data.add(Integer.parseInt(temp));
			}
			else
			{
				temp += datas.charAt(i);
			}
		}
		
		for(int i = 0; i< data.size();i++)
			System.out.println(""+data.get(i));
		
		
		System.out.println("This is numOfNodes " + numOfNodes );
		System.out.println("This is the data "+ datas);
	}
}
