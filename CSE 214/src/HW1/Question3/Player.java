package HW1.Question3;
/*CSE 214: Homework #1 Complexity Analysis and Abstract Data Types
 * Question 3
 * Wendy Hu
 * Student id#: 111560523
*/

import java.util.ArrayList;

public class Player {

	private int number;
	private Card[] cardsInHand = new Card[13];
	
	//Creating the constructor Player with parameter int Num
	public Player(int num)
	{
		number = num;
	}
	
	//returning the number of the player
	public int getNum(){
		return number;
	}
	
	//Sets the cards the player hold in hand, cardsInHand, to the cards "given" to the player
	public boolean setCards(Card[] cards){
		if(cards.length != cardsInHand.length)
		{
			return false;
		}else
		{
			for(int i = 0; i< cards.length; i++)
			{
				cardsInHand[i] = cards[i];
			}
			return true;
		}
	}
	
	//prints each card's string value out using a loop
	public void printCards(){
		for(int i = 0; i< cardsInHand.length;i++)
		{
			System.out.print(cardsInHand[i].getCard() + " ");
		}
	}
	
	//sorts the cards in suit and rank
	public void sortCards(){
		sortNums(); //sorts the cards first by their number/rank
		sortSuits(); //sorts the cards by their suits in order from spade, heart, diamond, clover
	}

	//using insertion sort to sort the cards by rank, using the number value that I created in the Card class = getNum()
	private void sortNums() {
		// TODO Auto-generated method stub
		for(int j = 1; j<cardsInHand.length;j++)
		{
			Card key = cardsInHand[j];
			int i = j-1;
			while((i>-1) && (cardsInHand[i].getNum() < key.getNum()))
			{
				//System.out.println(""+cardsInHand[j].getSuit() + " " + key.getSuit());
				cardsInHand[i+1] = cardsInHand[i];
				i--;
			}
			cardsInHand[i+1] = key;
		}
	}

	//using insertion sort to sort the cards by suit, using the suit number values that I created in the Card clas = getSuit()
	private void sortSuits() {
		// TODO Auto-generated method stub
		for(int j = 1; j<cardsInHand.length;j++)
		{
			Card key = cardsInHand[j];
			int i = j-1;
			while((i>-1) && (cardsInHand[i].getSuit() > key.getSuit()))
			{
				//System.out.println(""+cardsInHand[j].getSuit() + " " + key.getSuit());
				cardsInHand[i+1] = cardsInHand[i];
				i--;
			}
			cardsInHand[i+1] = key;
		}
	}
}
