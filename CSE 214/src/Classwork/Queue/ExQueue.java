package Classwork.Queue;

public class ExQueue {
	
	private class Team {
		
		private int number;

		public Team(int num){
			number = num;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListQueue<Team> teamQueue = new ListQueue<Team>();
		for(int i = 1; i < 8; i++)
		{
			Team t = new Team(i);
			teamQueue.enqueue(t);
			
		}
		Team j = new Team(5);

	}

}
