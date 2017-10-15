package HW1.Question4;
/*CSE 214: Homework #1 Complexity Analysis and Abstract Data Types
 * Question 4
 * Wendy Hu
 * Student id#: 111560523
*/

public class GPS {
	
	private Location current;
	private Location destin;
	private int distance;
	private double carSpeed;
	
	//Creating the constructor GPS
	public GPS(){
		
		current = null;
		destin = null;
	}
	
	//sets the current Location for the GPS
	public void setCurrentLocation(Location c){
		current = c;
	}
	
	//sets the destined Location for the GPS
	public void setDestination(Location d){
		destin = d;
	}
	
	//Calculates and returns the distance between the two locations using the math distance formula, 
	//distance =  the square root of ((X1 - X2)squared + (Y1 - Y2)squared)
	//Wasn't sure if the distance was wanted in double value or int value so I created the distance as an int value
	public int getCalculatedDistance(){
		distance = (int) Math.sqrt(Math.pow(destin.getX() - current.getX(), 2) + Math.pow(destin.getY() - current.getY(), 2));	
		return distance;
	}
	
	//sets the speed of the car in the GPS
	public void setCarSpeed(double speed){
		carSpeed = speed;
	}
	
	//using the speed of the car to calculate arrival time
	//Because I wasn't sure if the time should be double or int I left it in int value 
	public int getArrivalTime(){//need to figure this out
		return (int) (distance/carSpeed);
		
	}

}
