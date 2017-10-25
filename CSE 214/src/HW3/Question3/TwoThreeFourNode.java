package HW3.Question3;

public class TwoThreeFourNode {
	
	private final int num = 4;
	private int numItems;
	private TwoThreeFourNode parent;
	private TwoThreeFourNode childArr[] = new TwoThreeFourNode[num];
	private int itemArr[] = new int[num-1];
	
	public TwoThreeFourNode(){
		numItems = 0;
	}
	
	public void connect(int childNum, TwoThreeFourNode child)
	{
		childArr[childNum] = child;
		if(child != null)
			child.parent = this;
	}
	
	public TwoThreeFourNode disConnect(int childNum){
		TwoThreeFourNode temp = childArr[childNum];
		childArr[childNum] = null;
		return temp;
	}
	
	public TwoThreeFourNode getChild(int childNum){
		return childArr[childNum];
	}
	
	public TwoThreeFourNode getParent(){
		return parent;
	}
	
	public boolean isLeaf(){
		if(childArr[0] == null) return true;
		return false;
	}
	
	public int getNumItems(){
		return numItems;
	}
	
	public int getItem(int index){
		return itemArr[index];
	}
	
	public boolean isFull(){
		if(numItems == num) return true;
		return false;
	}
	
	public boolean findKey(int key){
		for(int i = 0; i< itemArr.length; i++)
		{
			if(itemArr[i] == key)
				return true;
		}
		return false;
	}
	
	public int insert(int newItem){
		itemArr[numItems] = newItem;
		numItems++;
		
		sort();
		return find(newItem);
	}
	
	private int find(int d){
		for(int i = 0; i< numItems; i++){
			if(itemArr[i] == d)
				return i;
		}
		return -1;
	}
	
	public int remove(){
		int temp = itemArr[numItems-1];
		itemArr[numItems-1] = 0;
		numItems--;
		return temp;
	}
	
	private void sort() {
		// TODO Auto-generated method stub
		for(int i = 1; i<numItems; i++){
			int key = itemArr[i];
			int j = i-1;
			
			while((j>-1) && itemArr[j] > key){
				itemArr[j+1] = itemArr[j];
				j--;
			}
			itemArr[j+1] = key;
		}
	}

	public void print(){
		for(int i = 0; i< itemArr.length; i++)
		{
			System.out.print(itemArr[i] + " ");
		}
	}

}
