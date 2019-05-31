
// BinaryTree class; stores a binary tree.
//
// CONSTRUCTION: with (a) no parameters or (b) an object to
//    be placed in the root of a one-element tree.
//
// *******************PUBLIC OPERATIONS**********************
// Various tree traversals, size, height, isEmpty, makeEmpty.
// Also, the following tricky method:
// void merge( Object root, BinaryTree t1, BinaryTree t2 )
//                        --> Construct a new tree
// *******************ERRORS*********************************
// Error message printed for illegal merges.


public class BinaryTree<T>
{
    
    private Node root;   // A pointer to the root of the Binary Tree.
    
    /*
     *    Construct an empty Tree.
     *    
     */

    public BinaryTree( )
    {
        root = null;
    }

    /*
     *    Construct a Binary Tree consisting of a single node.
     */
    
    public BinaryTree( T rootItem )
    {
        root = new Node(rootItem, null, null);
    }


    /*
     *    makeEmpty() - delete all Nodes from the Tree.
     */
    
    public void makeEmpty( )
    {
        root = null;
    }
    
    /*
     *    isEmpty() - return true if there are no Nodes
     *                in the tree, else return false.
     */

    public boolean isEmpty( )
    {
        return root == null;
    }
    
    /**
     *   Merge routine for BinaryTree class. 
     *   Forms a new tree from rootItem, t1 and t2.
     *   Does not allow t1 and t2 to be the same.
     *   Correctly handles other aliasing conditions.
     */
    
    public void merge(T rootItem, BinaryTree<T> t1, BinaryTree<T> t2 )
    {
        
        if( t1.root == t2.root && t1.root != null )
        {
            System.err.println( "leftTree==rightTree; merge aborted" );
            return;
        }

            // Allocate new node
        
        root = new Node( rootItem, t1.root, t2.root );
      
        if (t1.root != null)          // The roots of the subtree point
            t1.root.parent = root;    // back to the parent node.
        if (t2.root != null)
            t2.root.parent = root;

            // Ensure that every node is in only one tree
        
        if( this != t1 )
            t1.root = null;
        if( this != t2 )
            t2.root = null;
    }
    

    
    /*
     *    printTree() - display the binary tree.
     */
    
    public void printTree()
    {
        printBT(root, 0);   // Print the binary tree starting at the root.
    }
    
    /*
     *    printBT() - A recursive routine to print the Binary tree
     *                with given root parameter at the given level. 
     */
    
    private void printBT(Node root, int level)
    {

        if (root == null)    // Empty tree, nothing to print.
            return;

        printBT(root.rchild, level + 1);     // Print the right subtree.
            
        for (int i = 0; i < level; i++)              // Print the root node
            System.out.print("   ");                 // indented by an amount
        System.out.println(""+root.data.toString()); // corresponding to its
                                                     // level.
           
        printBT(root.lchild, level + 1 );    // Print the left subtree.
    }
    
    /*
     *   size() - Return the number of Nodes in the tree.
     */
    
    public int size()
    {
        return rsize(root);  // Call recursive function rsize().
    }
    
    /*
     *   rsize() - A recursive function to return the
     *             number of nodes in the tree with the
     *             given root parameter. 
     */
    
    private int rsize(Node root)
    {
        if (root == null)                  // Base case - empty tree.
            return 0;
        else                               // Inductive case.
            return 1 + rsize(root.lchild)  //   1 + size of left subtree
                     + rsize(root.rchild); //     + size of right subtree
    }
    
    /*
     *   height() - return the height of the tree.  The height of an empty
     *              tree is -1, otherwise the height is 1 plus
     *              the larger of the height of the root's left or right
     *              subtree.
     */
    
    public int height()
    {
        return rheight(root);
    }
    
    
    /*
     *   rheight() - a recursive function to return the
     *               height of the tree starting at the 
     *               parameter root.
     */
    
    private int rheight(Node root)
    {
		Node n = root;

		if (n == null)
			return -1; //empty tree
		else
		{
			int lHeight = rheight(n.lchild);
			int rHeight = rheight(n.rchild);
			
			if (lHeight > rHeight)
				return (lHeight + 1);
			else
				return (rHeight + 1);
		}       
    }
    
    
    /*
     *   numLeaf() - return the number of leaf nodes
     *               in the tree.
     */
    
    public int numLeaf()
    {
        return rnumLeaf(root);
    }
    
    /*
     *   rnumLeaf() - return the number of leaf nodes
     *                in the tree with given root
     *                parameter. 
     */
    
    private int rnumLeaf(Node root)
    {
		Node n = root;

        if (n == null)
			return 0;
		if (n.lchild == null && n.rchild == null)
			return 1;
		else
			return rnumLeaf(n.lchild) + rnumLeaf(n.rchild);
    }
    
        

        
    /*  main() - Used to construct a few binary trees to test out
     *           the implementation.
     */

    static public void main( String [ ] args )
    {
        BinaryTree<Integer> t1 = new BinaryTree<Integer>( 1 );  // Tree with root node 1
        BinaryTree<Integer> t3 = new BinaryTree<Integer>( 3 );  // Tree with root node 3
        BinaryTree<Integer> t5 = new BinaryTree<Integer>( 5 );  // Tree with root node 5
        BinaryTree<Integer> t7 = new BinaryTree<Integer>( 7 );  // Tree with root node 7
        BinaryTree<Integer> t2 = new BinaryTree<Integer>( );    // Empty tree
        BinaryTree<Integer> t4 = new BinaryTree<Integer>( );    // Empty tree
        BinaryTree<Integer> t6 = new BinaryTree<Integer>( );    // Empty tree
        BinaryTree<Integer> t9 = new BinaryTree<Integer>( );    // Empty tree
        
        BinaryTree<String> s1 = new BinaryTree<String>( "B" );  // Tree with root node 1
        BinaryTree<String> s2 = new BinaryTree<String>(); 
        BinaryTree<String> s3 = new BinaryTree<String>();
        BinaryTree<String> s4 = new BinaryTree<String>();
        BinaryTree<String> s5 = new BinaryTree<String>();

        s2.merge("A",s3,s1);

        s2.printTree();



        t2.merge( 2, t1, t3 );   // Merge trees to create new trees.
        t6.merge( 6, t5, t7 );
        t4.merge( 4, t2, t6 );
        // This next merge should fail
        t9.merge( 9, t4, t4 );
        

        System.out.println( "t4 should be perfect 1-7; t2 empty" );
        System.out.println( "----------------" );
        System.out.println( "t4" );
        System.out.println( "----------------" );
        System.out.println( "t2" );
        System.out.println( "----------------" );
        System.out.println( "t4 size: " + t4.size() );
        System.out.println( "t4 height: " + t4.height() );
        System.out.printf( "t4 has %d leafNodes.\n\n", t4.numLeaf() );
        
        t4.printTree();   // Print the tree.

        System.out.println( "\n----------------" );
        System.out.println( "s4 size: " + s4.size() );
        System.out.println( "s4 height: " + s4.height() );
        System.out.printf( "s4 has %d leafNodes.\n\n", s4.numLeaf() );
        System.out.println( "----------------\n" );
        
        
    }
    
    
    /*
     *   Node inner class.  A node of a binary tree.
     */

    private class Node
    {
        private T data;         // The data stored in the node.
        private Node lchild;    // Pointer to the left child Node.
        private Node rchild;    // Pointer to the right child Node.
        private Node parent;    // Pointer to the parent Node.
        
        /*
         *    Construct a null Node with all fields null.
         */
        
        public Node()
        {
            this.data = null;
            this.lchild = null;
            this.rchild = null;
            this.parent = null;
        }
        
        /*
         *   Construct a Node with specified data and
         *   left and right child pointers.
         */
        
        public Node(T data, Node lchild, Node rchild)
        {
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
            this.parent = null;
        }
    }
}
