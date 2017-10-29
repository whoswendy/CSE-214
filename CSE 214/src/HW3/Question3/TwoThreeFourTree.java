package HW3.Question3;

public class TwoThreeFourTree {
	
	private TwoThreeFourNode root;
	
	public TwoThreeFourTree(){
		
	}
	
	public boolean search(int key){
		return search(root, key);
		
	}
	
	private boolean search(TwoThreeFourNode node, int key) {//DONT KNOW IF IT WORKS :(
		// TODO Auto-generated method stub
		TwoThreeFourNode curr = node;
		while(curr != null){
			if(curr.findKey(key)){
				System.out.println("Success");
				return true;
			}else if(key < curr.getItem(0) && !curr.isLeaf()){
				return search(curr.getChild(0), key);
			}else if(key > curr.getItem(0) && key < curr.getItem(1) && !curr.isLeaf()){
				return search(curr.getChild(1), key);
			}else if(key > curr.getItem(1) && key < curr.getItem(2) && !curr.isLeaf()){
				return search(curr.getChild(2), key);
			}else if(key > curr.getItem(3) && !curr.isLeaf()){
				return search(curr.getChild(3), key);
			}
		}
		System.out.println("Failed");
		return false;
	}
	

	public void insert(int data){
		if(root == null){
			root = new TwoThreeFourNode();
		}
		TwoThreeFourNode curr = root;
		int temp = data;
		
		while(curr != null){
			if(curr.isFull()){
				split(curr);
				curr = curr.getParent();
			}else if(curr.isLeaf()){
				break;
			}else
			{
				curr = getNextChild(curr, data);
			}
		}
		curr.insert(data);
	}

	private TwoThreeFourNode getNextChild(TwoThreeFourNode curr, int data) {
		// TODO Auto-generated method stub
		int i;
		int numItems = curr.getNumItems();
		for(i = 0; i<numItems; i++){
			if(data < curr.getItem(i))
			{
				return curr.getChild(i);
			}
		}
		return curr.getChild(i);
	}

	private void split(TwoThreeFourNode current) {
		// TODO Auto-generated method stub
		int temp1;
		int temp2;
		TwoThreeFourNode parent;
		TwoThreeFourNode child2;
		TwoThreeFourNode child3;
		int itemIndex;
		
		temp1 = current.remove();
		temp2 = current.remove();
		child2 = current.disConnect(2);
		child3 = current.disConnect(3);
		
		TwoThreeFourNode newRight = new TwoThreeFourNode();
		if(current == root){
			root = new TwoThreeFourNode();
			parent = root;
			root.connect(0, current);
		}else{
			parent = current.getParent();
			
			itemIndex = parent.insert(temp1);
			int n = parent.getNumItems();
			
			for(int i = n-1; i > itemIndex; i--){
				TwoThreeFourNode temp = parent.disConnect(i);
				parent.connect(i+1, temp);
			}
			
			parent.connect(itemIndex+1, newRight);
			
			newRight.insert(temp2);
			newRight.connect(0, child2);
			newRight.connect(1, child3);
		}
		
	}
	
	public void inorder(){
		inorder(root);
	}

	private void inorder(TwoThreeFourNode node){
		if(node.isLeaf())
			return;
		else if(node.getNumItems() == 3){
			inorder(node.getChild(0));
			node.getChild(0).print();
			inorder(node.getChild(1));
			node.getChild(1).print();
			inorder(node.getChild(2));
			node.getChild(2).print();
		}else{
			inorder(node.getChild(0));
			node.getChild(0).print();
			inorder(node.getChild(1));
		}
		
		
	}
}
