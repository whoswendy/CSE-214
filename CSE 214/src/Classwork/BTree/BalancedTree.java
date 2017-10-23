package Classwork.BTree;

public class BalancedTree {
	
	private BNode root;
	
	public BalancedTree(){
		root = null;
	}
	
	public boolean isEmpty(){
		if(root == null)
			return true;
		return false;
	}
	
	public void clear(){
		root = null;
	}
	
	 /* Function to insert data */
    public void insert(int data)
    {
        root = insert(data, root);
    }
    
    /* Function to get height of node */
    private int height(BNode t )
    {
        return t == null ? -1 : t.getHeight();
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    /* Function to insert data recursively */
    private BNode insert(int x, BNode t)
    {
        if (t == null)
            t = new BNode(x);
        else if (x < t.getData())
        {
            t.left = insert( x, t.left );
            if (height( t.left ) - height( t.right ) == 2)
                if (x < t.left.getData())
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if (x > t.getData())
        {
            t.right = insert( x, t.right );
            if (height( t.right ) - height( t.left ) == 2)
                if (x > t.right.getData())
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
          ;  // Duplicate; do nothing
        t.setHeight(max( height( t.left ), height( t.right ) ) + 1);
        return t;
    }
    /* Rotate binary tree node with left child */     
    private BNode rotateWithLeftChild(BNode k2)
    {
        BNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.setHeight(max( height( k2.left ), height( k2.right ) ) + 1);
        k1.setHeight(max( height( k1.left ), k2.getHeight() ) + 1);
        return k1;
    }

    /* Rotate binary tree node with right child */
    private BNode rotateWithRightChild(BNode k1)
    {
        BNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.setHeight(max( height( k1.left ), height( k1.right ) ) + 1);
        k2.setHeight(max( height( k2.right ), k1.getHeight() ) + 1);
        return k2;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private BNode doubleWithLeftChild(BNode k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */      
    private BNode doubleWithRightChild(BNode k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }    
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(BNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /* Functions to search for an element */
    public boolean search(int val)
    {
        return search(root, val);
    }
    private boolean search(BNode r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.getData();
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(BNode r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.getData() +" ");
            inorder(r.right);
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(BNode r)
    {
        if (r != null)
        {
            System.out.print(r.getData() +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(BNode r)
    {
        if (r != null)
        {
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.getData() +" ");
        }
    }     

}
