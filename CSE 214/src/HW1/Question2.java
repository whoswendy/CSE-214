package HW1;
/*CSE 214: Homework #1 Complexity Analysis and Abstract Data Types
 * Question 2a,b,c
 * Wendy Hu
 * Student id#: 111560523
*/

import java.util.Calendar;

public class Question2 {

	/*Question 2
	 * a. Add ​ ​an ​ ​action ​ ​method ​ ​​chargeIt(price)​, ​ ​which ​ ​is​ ​called ​ ​on ​ ​a ​ ​new​ ​transaction. ​ ​This​ ​method
takes​ ​price ​ ​as​ ​argument ​ ​and ​ ​returns​ ​whether​ ​transaction ​ ​was​ ​successful ​ ​or​ ​not. ​ ​If ​ ​the
purchase ​ ​makes​ ​the ​ ​balance ​ ​exceed ​ ​the ​ ​limit, ​ ​transaction ​ ​should ​ ​fail.*/
	//When using the credit card checking if the price added to the balance is greater than limit if it is transaction fails
	public boolean chargeIt(int price){
		boolean transaction = true;
		if(balance + price > limit)
		{
			transaction = false;
			return transaction;
		}
		return transaction;	
	}
	
	/*b.Add ​ ​an ​ ​action ​ ​method ​ ​​payment(amount)​, ​ ​which ​ ​is​ ​called ​ ​when ​ ​cardholder​ ​makes​ ​a
payment.*/
	//subtracting the amount used from possible balance
	public void payment(int amount){

			balance = balance - amount;
	}
	
	/*c. Make ​ ​necessary​ ​changes​ ​to ​ ​add ​ ​a ​ ​late ​ ​fee ​ ​if ​ ​payment ​ ​is​ ​done ​ ​after​ ​due ​ ​date ​ ​(15th ​ ​of ​ ​the
month).*/
	//Using the calendar to check if the date of the month is > 15 if it is there is a late fee and that late fee will be subtracted
	//from the balance along with the price.
	//If the payment is not late, date < 15, then only the payment is subtracted from balance.
	public void payment(int amount){
		Calendar calend = Calendar.getInstance();
		calend.setTime(mar.getEventDate());
		int day = calend.get(Calendar.DAY_OF_MONTH);
		if(day > 15)
		{
			balance = balance - (amount * 1.1); //having to pay 10% late fee
		}
		else{
			balance = balance - amount;
		}
	}
}
