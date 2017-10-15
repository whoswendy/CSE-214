package HW1.Question3;
/*CSE 214: Homework #1 Complexity Analysis and Abstract Data Types
 * Question 3
 * Wendy Hu
 * Student id#: 111560523
*/

public class CardSampleTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Sample deck values
		String[] cardsForPlayer = {"S4","D8","C4","D3","D5","DJ","S3","D4","DA","SJ","D7","H10","D6"};
		String[] cardsForPlayer2 = {"S4","DK","CQ","S9","DJ","H6","S10","C8","S3","H7","C4","D6","SJ"};
		String[] cardsForPlayer3 = {"C4","CK","SQ","D9","HJ","D6","S10","C8","H3","H7","D4","S6","SJ"};
		Card[] cards = new Card[13];
		for(int i = 0; i < cardsForPlayer3.length;i++){
			Card mCard = new Card(cardsForPlayer3[i]);
			cards[i]=mCard;
		}
		
		//Creating new player
		int id =1;
		Player player = new Player(id);
		player.setCards(cards);
		
		//sorting the cards and printing
		//See output
		player.sortCards();
		player.printCards();
		
	}

}
