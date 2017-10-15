package HW1.Question4;
/*CSE 214: Homework #1 Complexity Analysis and Abstract Data Types
 * Question 4
 * Wendy Hu
 * Student id#: 111560523
*/

public class Car {
	
	private GPS myGPS;
	private double speed;
	
	//Creating the constructor Car
	public Car(){
		myGPS = null;
		speed = 0.0;
	}
	
	//Setting the gps of the car
	public void setGPS(GPS g){
		myGPS = g;
	}
	
	//Setting the speed of the car and letting the gps of the car know the car's speed if the car has a gps
	public void setCurrentSpeed(double s)
	{
		speed = s;
		if(myGPS != null)
		myGPS.setCarSpeed(speed);
	}
	
	//returns the gps of the car
	public GPS getGPS(){
		return myGPS;
	}

}
