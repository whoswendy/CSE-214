package HW2.Question1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import HW2.LinkedList;

/*CSE 214: Homework #2 Linked List, Stack and Queues
 * Question 1
 * Wendy Hu
 * Student id#: 111560523
*/
public class Question1 {
	
	private static int newFriends;
	private static int keepFriends;
	private static String[] newlyAddedFriends;
	private static int[] numOfMutualFriends;
	private static int min;
	private static int max;

	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(new File("in1.txt"));//This is where the location of the file needs to be inserted
		
		while(input.hasNextLine()){
			String testNumber = input.nextLine();
			System.out.println("Testcase "+ testNumber);
			
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
					else
						temp += stringTemp.charAt(i);
			}
			newFriends = Integer.parseInt(tempArr.get(0));
			keepFriends = Integer.parseInt(tempArr.get(1));
			
			String stringTemp2 = input.nextLine();
			ArrayList<String> tempArr2 = new ArrayList<String>();
			String temp2 = "";
			for(int i = 0; i< stringTemp2.length(); i++)
			{
				if(stringTemp2.charAt(i) == ' ')
				{
					tempArr2.add(temp2);
					temp2 = "";
				}else
					temp2 += stringTemp2.charAt(i);
			}
			newlyAddedFriends = new String[tempArr2.size()];
			for(int i = 0; i< newlyAddedFriends.length;i++)
				newlyAddedFriends[i] = tempArr2.get(i);
			
			String stringTemp3 = input.nextLine();
			ArrayList<String> tempArr3 = new ArrayList<String>();
			String temp3 = "";
			for(int i = 0; i< stringTemp3.length(); i++)
			{
				if(stringTemp3.charAt(i) == ' ')
				{
					tempArr3.add(temp3);
					temp3 = "";
				}else
					temp3 += stringTemp3.charAt(i);
			}
			numOfMutualFriends = new int[tempArr2.size()];
			for(int i = 0; i< numOfMutualFriends.length;i++)
				numOfMutualFriends[i] = Integer.parseInt(tempArr3.get(i));
			
//		keepFriends = 3;
//		newlyAddedFriends = new String[]{"a", "b" ,"c", "d" ,"e", "f", "g", "h", "i", "j"};
//		numOfMutualFriends = new int[]{10, 2, 4, 5, 7, 3, 2, 9, 11, 6};
			
			min = findMin(numOfMutualFriends);
			max = findMax(numOfMutualFriends);
			
			sort(numOfMutualFriends,newlyAddedFriends);
			int r = Math.round((max - min + 1)/keepFriends);
			
			for(int i = 0; i< keepFriends; i++)
			{
				if(min+r == max)
				{
					range(min,r+1);
				}
				else
					range(min,r);
			}
			System.out.println("");
		}

	}
	
	private static void sort(int[] arr, String[] arr2) {
		// TODO Auto-generated method stub
		for(int j = 1; j<arr.length;j++)
		{
			int key = arr[j];
			String key2 = arr2[j];
			int i = j-1;
			while((i>-1) && (arr[i] > key))
			{
				arr[i+1] = arr[i];
				arr2[i+1] = arr2[i];
				i--;
			}
			arr[i+1] = key;
			arr2[i+1] = key2;
		}
	}
//	public static void range(int start, int r){
//		LinkedList<String> bucket = new LinkedList<String>();
//			for(int i = 0; i<numOfMutualFriends.length;i++)
//			{
//				if(numOfMutualFriends[i] >= start && numOfMutualFriends[i] < start+r && bucket.isEmpty())
//					bucket.addToStart(newlyAddedFriends[i]);
//				else if(numOfMutualFriends[i] >= start && numOfMutualFriends[i] < start+r)
//					bucket.add(newlyAddedFriends[i]);
//			}
//			//bucket.outPutList();
//			
//			int count = 1;
//			int pos = 0;
//			while(bucket.findLength() >1)
//			{
//				if(count == keepFriends){
//					bucket.remove(pos);
//					LinkedList<String> temp = new LinkedList<String>();
//					for(int i = 0; i< bucket.findLength(); i++)
//					{
//						if(i == 0)
//						{
//							temp.addToStart(bucket.get(i));
//						}
//						else
//							temp.add(bucket.get(i));
//					}
//					bucket = temp;
//					count = 1;
//				}
//				else{
//					if(pos >= bucket.findLength())
//					{
//						pos = 0;
//						count = count + 1;
//					}
//					else
//					{
//						count = count +1;
//						pos = pos + 1;						
//					}
//				}
//			}
//			min = min +r;
//			bucket.outPutList();
//	}

	public static void range(int start, int r)
	{
		LinkedList<String> bucket = new LinkedList<String>();

		for(int i = 0; i<numOfMutualFriends.length;i++)
		{
			if(numOfMutualFriends[i] >= start && numOfMutualFriends[i] < start+r && bucket.isEmpty())
				bucket.addToStart(newlyAddedFriends[i]);
			else if(numOfMutualFriends[i] >= start && numOfMutualFriends[i] < start+r)
				bucket.add(newlyAddedFriends[i]);
		}
		int count = 1;
		int pos = 0;

		while(bucket.findLength() > 1 )
		{
			//System.out.println("bucket = " + bucket.findLength());
			if(pos >= bucket.findLength()-1)
			{
				//System.out.println("pos = " + pos);
				pos = 1;
			}
			if(count == keepFriends)
			{
				bucket.remove(pos);
				pos++;
				count = 0;
			}
			else{
				count++;					
				pos++;
			}
		}

		min = min +r;
		bucket.outPutList();
	}

	
	public static int findMin(int[] arr){
		int min = arr[0];
		for(int i = 0; i< arr.length; i++)
		{
			if(arr[i] < min)
			{
				min = arr[i];
			}
		}
		return min;
	}
	
	public static int findMax(int[] arr){
		int max = arr[0];
		for(int i = 0; i< arr.length; i++)
		{
			if(arr[i] > max)
			{
				max = arr[i];
			}
		}
		return max;
	}
	
	
}
