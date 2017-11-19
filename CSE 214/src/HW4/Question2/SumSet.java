package HW4.Question2;

public class SumSet {
	
	private int a;
	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}

	private int b;
	private int c;
	
	public SumSet(int x1,int x2,int x3){
		a=x1;
		b=x2;
		c=x3;
	}
	
	public boolean equals(SumSet other){
		if(other.getA() == a || other.getB() == a || other.getC() == a){
			if(other.getA() == b || other.getB() == b || other.getC() == b){
				if(other.getA() == c || other.getB() == c || other.getC() == c){
					return true;
				}
			}
		}
		return false;
	}	
	
	public void print(){
		System.out.println(a + " + " + b + " + " + c);
	}

}

