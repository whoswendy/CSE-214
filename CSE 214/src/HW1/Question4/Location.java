package HW1.Question4;
/*CSE 214: Homework #1 Complexity Analysis and Abstract Data Types
 * Question 4
 * Wendy Hu
 * Student id#: 111560523
*/

public class Location {

	private int x;
	private int y;
	
	//Creating the constructor Location with parameters for location values
	public Location(int a, int b){
		
		x = a;
		y = b;
	}
	
	//returns the x value of the location
	public int getX(){
		return x;
	}
	
	//returns the y value of the location
	public int getY(){
		return y;
	}
}
