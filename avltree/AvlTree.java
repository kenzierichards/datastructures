import java.util.Scanner;


/*
 *    An implementation of an AVL Tree.
 */

public class AvlTree<T extends Comparable<T>>
{
    private Node root = null;   // Pointer to the root of the AVL Tree

    // The following variables are used during a
    // restructuring of the tree.

    private Node pivotParent = null; // Pointer to the pivot node's parent.
    private Node pivotNode = null; // Pointer to the pivot node.
    private Node pivotChild = null; // Pointer to pivot's child along the search path.
    private Node pivotGrandchild = null; // Pointer to pivot's grandchild along the search path.

                                         // Constants to name the rotations.
    private final static int LL = 0;     //    Left-Left Rotation.
    private final static int LR = 1;     //    Left-Right Rotation.
    private final static int RR = 2;     //    Right-Right Rotation.
    private final static int RL = 3;     //    Right-Left Rotation.



    public AvlTree()
    {
        this.root = null;   // Start out with an empty tree.
    }


    public void insert(T x)
    {
        avl_insert(x);      // Insert into an AVL tree - restructure as needed.
    }


    private void avl_insert(T x)
    {
        int rotType;  // Type of rotation needed to balance the tree.

        if (search(x))     // Only attach if the new data is not in the tree.
            return;

        attach(x);                // Add the new node to the tree.
        pivotNode = pivot(x);            // Find the pivot node;

        if (pivotNode == null)             // If there's no pivot Node
            resetbalance(root,x);   //     reset bf's from root along the search path.
        else if (addToShort(pivotNode,x))  // Elseif (node added to pivot's shorter subtree)
            resetbalance(pivotNode,x);     //     reset bf's from pivot along the search path.
        else {                      // Else (node added to pivot's longer subtree)
            resetbalance(pivotNode,x);     //     restructure the tree.

            setpointers(x);             // Set pointers pivotParent, pivotNode, pivotChild , pivotGrandchild in preparation
                                        // to perform a rotation and re-balance the tree.
            rotType = find_rotType(x);  // Determine the kind of rotation to perform.

            switch (rotType) {
                case LL: LL_rotation(); break;
                case LR: LR_rotation(); break;
                case RL: RL_rotation(); break;
                case RR: RR_rotation(); break;
            }
        }
    }


    //
    //   find_rotType() - This function returns the type of rotation
    //                    (LL, LR, RR, RL) needed to maintain the balance
    //                    of a tree when a new node has been attached
    //                    that unbalances the tree.
    //          pivotNode points to the pivot node upon entry to the function.
    //

    private int find_rotType(T x)
    {       
		Node n = pivotNode;
		String one = "";
		String two = "";	

			if (n.data.compareTo(x) > 0)
			{
				n = n.lchild;
				one = "left";
			}
			else
			{
				n = n.rchild;
				one = "right";
			}
			
			if (n.data.compareTo(x) > 0)
			{
				n = n.lchild;
				two = "left";
			}
			else
			{
			    n = n.rchild;
				two = "right";
        	}

		String rot = one + " " + two;
		
		switch (rot)
		{
			case "left left":
			{
				return LL;
			}	
			case "left right":
			{
				return LR;
			}
			case "right right":
			{
				return RR;
			}
			case "right left":
			{
				return RL;
			}
			default:
			{
				System.out.println("Error");
				return 0;
			}

		} 
    }

    //
    //  resetbalance()  -  Reset the balance factors when a new node with
    //                     data value x is attached to the avl tree.  Only
    //                     those nodes along the search path starting from
    //                     the node addressed by the parameter p need to have
    //                     their balance factors set.
    //

    private void resetbalance(Node p, T x)
    {
		while (p.data.compareTo(x) != 0)
		{
        	if (p.data.compareTo(x) < 0)
			{
				p.bf--;
				p = p.rchild;
			}
			else if (p.data.compareTo(x) > 0)
			{
				p.bf++;
				p = p.lchild;
			}
    	}
	}

    //
    //  setpointers() - Upon entry, pivotNode points to the pivot node associated
    //                  with the attaching of a new node with data value x.
    //                  Instance variable pivotParent, pivotChild, pivotGrandchild are set as follows:
    //
    //                      pivotParent = parent of the pivot, else null.
    //                      pivotChild = child of pivot along search path.
    //                      pivotGrandchild = grandchild of the pivot along search path.
    //

    private void setpointers(T x)
    {
       if (pivotNode.data.compareTo(x) > 0)
		{
			pivotChild = pivotNode.lchild;
		}
		else
		{
			pivotChild = pivotNode.rchild;
		}

		if (pivotChild.data.compareTo(x) > 0)
		{
			pivotGrandchild = pivotChild.lchild;
		}
		else
		{
			pivotGrandchild = pivotChild.rchild;
		}

		if (root == pivotNode)
		{
			pivotParent = null;
			return;
		}
		System.out.println("print tree");
		printTree();
			
		Node n = root;		
		boolean done = false;

		while (!done)
		{
			if (n.lchild != null && n.lchild == pivotNode)
			{
				pivotParent = n;
				return;
			}
			else if (n.rchild != null && n.rchild == pivotNode)
			{
				pivotParent = n;
				return;
			}
			if (n.lchild != null && n.lchild.data.compareTo(pivotNode.data) > 0)
			{
				n = n.lchild;
			}
			else if (n.rchild != null && n.rchild.data.compareTo(pivotNode.data) < 0)
			{
				n = n.rchild;
			}
		}
		printTree();
    }


    //
    //  addToShort() - Determines, by looking at balance factors, if
    //                 the new node with data value x was added to
    //                 the subtree of the pivot node with the smaller
    //                 height.  If so, the function returns tree,
    //                 otherwise it returns false.
    //


    private boolean addToShort(Node pivotNode, T x)
    {
        if (pivotNode.data.compareTo(x) < 0 && pivotNode.bf == 1)       // New node added on right
            return true;                                  // tree but left is longer.
        else if (pivotNode.data.compareTo(x) > 0 && pivotNode.bf == -1) // New node added on left
            return true;                                  // tree but right is longer.
        else                  // ... New node must have been added to
            return false;     //     the longer subtree of the pivot.
    }


    //
    // pivot() - Return a pointer to the pivot node associated with the newly inserted
    //           node with data value x.  The pivot is the node on the search path,
    //           with nonzero balance factor, closest to the new node.
    //

    private Node pivot(T x)
    {
        Node p;  // A pointer used to traverse down the tree.

        this.pivotNode = null;      // Return null if there is no pivot node.

        if (root != null) {  // Start the search from the top of the tree.
            p = root;
            while (p.data.compareTo(x) != 0) {   // Not at the leaf yet.
                if (p.bf != 0)                        // Found a potential pivot further down
                    pivotNode = p;                           // the tree, update pivotNode.

                if (p.data.compareTo(x) < 0)     // ... p follows the search path
                    p = p.rchild;                //     down to the newly inserted
                else                             //     node.
                    p = p.lchild;
            }
        }

        return pivotNode;
    }


    //
    //  LL_rotation() - rebalance the tree by performing
    //                  an LL rotation of the nodes.
    //

    private void LL_rotation()
    {
        System.out.println("Doing LL rotation");
		
		if (pivotNode == root)
		{
			root = pivotNode.lchild;
		}
		
		pivotNode.lchild = pivotChild.rchild;
		pivotChild.rchild = pivotNode;

		pivotNode.bf = 0;
		pivotChild.bf = 0;

		if (pivotParent != null)
		{
			if (pivotParent.lchild == pivotNode)
			{
				pivotParent.lchild = pivotChild;
			}
			else if (pivotParent.rchild == pivotNode)
			{
				pivotParent.rchild = pivotChild;
			}
		}
    }

    //
    //  LR_rotation() - rebalance the tree by performing
    //                  an LL rotation of the nodes.
    //

    private void LR_rotation()
    {
		if (pivotGrandchild.bf < 0)
		{ //added to the right
			pivotChild.bf = 1;
			pivotNode.bf = 0;
		}
		else if (pivotGrandchild.bf == 0)
		{
			pivotNode.bf = 0;
			pivotChild.bf = 0;
		}
		else
		{ //added to left
			pivotChild.bf = 0;
			pivotNode.bf = -1;
		}

		if (pivotParent == null)
		{
			root = pivotGrandchild;
		}
		else
		{
			if (pivotParent.lchild == pivotNode)
			{
				pivotParent.lchild = pivotGrandchild;
			}
			else
			{
				pivotParent.rchild = pivotGrandchild;
			}
		}

		pivotChild.rchild = pivotGrandchild.lchild;
		pivotNode.lchild = pivotGrandchild.rchild;
		pivotGrandchild.rchild = pivotNode;
		pivotGrandchild.lchild = pivotChild;

        System.out.println("Doing LR rotation");
    }


    //
    //  RR_rotation() - rebalance the tree by performing
    //                  an LL rotation of the nodes.
    //

    private void RR_rotation()
    {
        System.out.println("Doing RR rotation");

		if (pivotNode == root)
        {
            root = pivotNode.rchild;
        }

		pivotNode.rchild = pivotChild.lchild;
        pivotChild.lchild = pivotNode;

        pivotNode.bf = 0;
        pivotChild.bf = 0;

        if (pivotParent != null)
        {
            if (pivotParent.lchild == pivotNode)
            {
                pivotParent.lchild = pivotChild;
            }
            else if (pivotParent.rchild == pivotNode)
            {
                pivotParent.rchild = pivotChild;
            }
        }

    }

    //
    //  RL_rotation() - rebalance the tree by performing
    //                  an LL rotation of the nodes.
    //

    private void RL_rotation()
    {
        System.out.println("Doing RL rotation");

		if (pivotGrandchild.bf < 0)
        { //added to the right
            pivotChild.bf = 0;
            pivotNode.bf = 1;
        }
        else if (pivotGrandchild.bf == 0)
        {
            pivotNode.bf = 0;
            pivotChild.bf = 0;
        }
        else
        { //added to left
            pivotChild.bf = -1;
            pivotNode.bf = 0;
        }

        if (pivotParent == null)
        {
            root = pivotGrandchild;
        }
        else
        {
            if (pivotParent.rchild == pivotNode)
            {
                pivotParent.rchild = pivotGrandchild;
            }
            else
            {
                pivotParent.lchild = pivotGrandchild;
            }
        }

		pivotChild.lchild = pivotGrandchild.rchild;
        pivotNode.rchild = pivotGrandchild.lchild;
        pivotGrandchild.lchild = pivotNode;
        pivotGrandchild.rchild = pivotChild;

    }


    /*
     *  attach() - attach a node with data value x
     *             in the Binary Search Tree.
     */

    public void attach(T x)
    {
        this.root = rattach(this.root, x);
    }


    /*
     *   rattach() - return a pointer to the root of a BST
     *               with data item x inserted.  Do not
     *               insert duplicate data items.
     */

    public Node rattach(Node root, T x)
    {
        if (root == null)                          // Base Step - Empty tree
            root =  new Node(x, null, null, 0);
        else if (x.compareTo(root.data) < 0)        // Smaller values go in
            root.lchild =  rattach(root.lchild, x); // the left subtree,
        else if (x.compareTo(root.data) > 0)        // larger values go in
            root.rchild =  rattach(root.rchild, x); // the right subtree.

        return root;
    }


    public void printTree()
    {
        rPrintTree(root,0);
    }

    /*
     *    rPrintTree() - the usual quick recursive method to print a tree.
     */

    public void rPrintTree(Node r, int level)
    {

        if (r == null)          // Empty tree, nothing to print.
            return;

        rPrintTree(r.rchild, level + 1);        // Print the right subtree.

        for (int i = 0; i < level; i++)
            System.out.print("     ");

        System.out.println(r.data.toString()+"("+r.bf+")");  // Print the root.

        rPrintTree(r.lchild, level + 1);        // Print the left subtree.
    }

    public boolean empty()
    {
        return this.root == null;
    }

    public boolean search(T x)
    {
        boolean here = false;
        Node ptr = this.root;

        while (ptr != null)
            if (ptr.data.compareTo(x) == 0)
                return true;
            else if (ptr.data.compareTo(x) < 0)
                ptr = ptr.rchild;
            else
                ptr = ptr.lchild;

        return false;
    }


    public static void main(String[] args)
    {
        AvlTree<Integer> t1 = new AvlTree<Integer>();

        Scanner keyb = new Scanner( System.in );  // Scanner to read from keyboard.
        int value = 0;                            // Value to insert into tree.

        do {
            // Read a value to insert into the tree.

            System.out.print("Insert what integer (-1 to quit)? ");
            value = keyb.nextInt();

            if (value != -1) {         // a value of -1 terminates the program.
                    t1.insert(value);  // Insert the value into the AVL tree.
                    t1.printTree();    // Check if value was correctly inserted.
            }
        } while (value != -1);

        System.out.println("\nProgram terminating\n");
    }


    // inner class - a Node in the AVL tree.

    public class Node
    {
        T data;       // The data item stored in the node.
        Node lchild;  // Pointer to left child (left subtree).
        Node rchild;  // Pointer to right child (right subtree).
        int  bf;      // The Balance Factor of the node.

        public Node()
        {
            this.data = null;
            this.lchild = null;
            this.rchild = null;
            this.bf = 0;
        }

        public Node(T data, Node lchild, Node rchild, int bf)
        {
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
            this.bf = bf;
        }

    }
}
