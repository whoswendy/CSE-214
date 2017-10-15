package HW1.Question4;
/*CSE 214: Homework #1 Complexity Analysis and Abstract Data Types
 * Question 4
 * Wendy Hu
 * Student id#: 111560523
*/

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating a new car and a new gps
		Car myCar = new Car();
		GPS myGPS = new GPS();
		
		//Creating a new current location and a new destined location
		Location myCurrent = new Location(0,0);
		Location myDestined = new Location(334,54);
		
		//setting the gps's locations
		 myGPS.setCurrentLocation(myCurrent);
		 myGPS.setDestination(myDestined);
		 
		 //setting the car's gps and speed
		 myCar.setGPS(myGPS);
		 myCar.setCurrentSpeed(25.0);
		 
		 //calculating the distance and the arrival time
		 //See output
		 System.out.println("Distance = " + myCar.getGPS().getCalculatedDistance());
		 System.out.println("Arrival in = " + myCar.getGPS().getArrivalTime() + "hours");

	}

}
