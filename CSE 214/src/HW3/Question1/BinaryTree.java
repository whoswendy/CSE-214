package HW3.Question1;

public class BinaryTree {
	
	private Node root;
	private int size;
	private int[] arr;
	private int[] pos;
	private int i = 0;
	private int numSwaps;
	
	private class Node{
		Node left;
		Node right;
		
		int data;
		
		public Node(){
			left = null;
			right = null;
			data = 0;
		}
		
		public Node(int d){
			left = null;
			right = null;
			data = d;
		}
		
		public void setLeft(Node l){
			left = l;
		}
		
		public void setRight(Node r){
			right = r;
		}
		
		public Node getLeft(){
			return left;
		}
		
		public Node getRight(){
			return right;
		}

		public int getData() {
			// TODO Auto-generated method stub
			return data;
		}
	}
	
	public BinaryTree(String numOfNodes){
		root = null;
		size = Integer.parseInt(numOfNodes);
		arr = new int[size];
		pos = new int[size];
	}
	
	public void insert(int d){
		insert(root,d);
	}

    private Node insert(Node node, int data)
    {
    	if(node == root && root == null){
    		root = new Node(data);
    	}
    	else if (node == null)
            node = new Node(data);
        else
        {
            if (node.getLeft() == null)
                node.left = insert(node.left, data);
            else 
                node.right = insert(node.right, data);             
        }
        return node;
    }     
	
	public void inorder(){
		inorder(root);
	}

	private void inorder(Node n) {
		// TODO Auto-generated method stub
		if(n != null){
			inorder(n.getLeft());
			arr[i] = n.getData();
			pos[i] = n.getData();
			i++;
			System.out.print(n.getData() + " ");
			inorder(n.getRight());
		}
	}
	
	public boolean isEmpty(){
		if(root == null)
			return true;
		else return false;
	}
	
	public void changeToBST(){

		sort();
		compare(pos,arr);
		System.out.println(""+(numSwaps-1));
	}

	private void compare(int[] a, int[] b) {
		// TODO Auto-generated method stub
		for(int i = 0; i< a.length; i++){
			if(a[i] == b[i]){
				numSwaps++;
			}
		}
		numSwaps = size - numSwaps;
	}

	private void sort() {
		// TODO Auto-generated method stub
		for(int i = 1; i< arr.length; i++){
			int key = arr[i];
			int j = i -1;
			while((j > -1) && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	

}
