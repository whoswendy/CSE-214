package HW1.Question3;
/*CSE 214: Homework #1 Complexity Analysis and Abstract Data Types
 * Question 3
 * Wendy Hu
 * Student id#: 111560523
*/

public class Card {

	private String card;
	private int suit;
	private int num;
	
	//Creating the constructor for Card with parameter string for value of the card
	//Also looping through arrays of values to find the suit and number value of the card
	public Card(String s)
	{
		card = s;
		String[] suits = {"S","H","D","C"};//the lower the index of the suit the higher it is
		String[] nums = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};//the higher the index of the suit the greater it is
		for(int i = 0; i< suits.length; i++)
		{
			if(s.substring(0,1).equalsIgnoreCase(suits[i])){
				suit = i;
				break;
			}
		}
		for(int j = 0; j< nums.length; j++)
		{
			if(s.substring(1).equalsIgnoreCase(nums[j])){
				num = j;
				break;
			}
		}
		
	}
	
	//returns the value of the card = the string
	public String getCard(){
		return card;
	}
	
	//returns the value of the card's suit if 0 = spade, 1 = heart, 2 = diamond, 3 = clover
	//Using these values in sorting
	public int getSuit(){
		return suit;
	}
	
	//returns the value of the card's rank if 0 = A, 1 = 2, 2 = 3.... 11 = Q, 12 = K
	//Using these values in sorting
	public int getNum(){
		return num;
	}
}
