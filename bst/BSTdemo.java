/*
 *   A program to exercise an implementation
 *   of a Binary Search Tree.
 */

public class BSTdemo {


    public static void main(String[] args)
    {

        BST<Integer> t1 = new BST<Integer>();  // Create some Binary Search Trees
        BST<Integer> t2 = new BST<Integer>();
        BST<Integer> t3 = new BST<Integer>();
        BST<Integer> t4 = new BST<Integer>();
        BST<Integer> t5 = new BST<Integer>();
        BST<Integer> t6 = new BST<Integer>();
        BST<Integer> t7 = new BST<Integer>();
        BST<Integer> t8 = new BST<Integer>();
        BST<Integer> t9 = new BST<Integer>();
  

        t1.insert(40);   // Two identical trees are created to test the equals()
        t1.insert(60);   // method.  To test trees that are not equal, simply
        t1.insert(20);   // comment out one of the Insertions - or change one of
        t1.insert(50);   // the data values.
        t1.insert(new Integer(80));
        t1.insert(70);
        t1.insert(10);
        t1.insert(48);
        t1.insert(41);
        t1.insert(46);
        t1.insert(47);
        t1.insert(44);
        t1.insert(5);
        t1.insert(15);


        t2.insert(40);
        t2.insert(60);
        t2.insert(20);
        t2.insert(50);
        t2.insert(80);
        t2.insert(70);
        t2.insert(10);
        t2.insert(48);
        t2.insert(41);
        t2.insert(46);
        t2.insert(47);
        t2.insert(44);
        t2.insert(5);
        t2.insert(15);

        System.out.println("-------------------------");
        t1.printTree();
        System.out.println("-------------------------");
        t2.printTree();
        System.out.println("-------------------------");



        if (t1.equals(t2))
            System.out.println("Tree t1 equals tree t2");
        else
            System.out.println("Tree t1 doesn't equal tree t2");

        System.out.println("---------------------");

        t4.insert(40);   // Two identical trees are created to test the equals()
        t4.insert(60);   // method.  To test trees that are not equal, simply
        t4.insert(20);   // comment out one of the Insertions - or change one of
        t4.insert(new Integer(50));   // the data values.
        t4.insert(80);
        t4.insert(90);
        t4.insert(new Integer(10));
        t4.insert(48);
        t4.insert(41);
        t4.insert(46);
        t4.insert(47);
        t4.insert(44);
        t4.insert(5);
        t4.insert(15);


        t5.insert(40);
        t5.insert(60);
        t5.insert(20);
        t5.insert(50);
        t5.insert(80);
        t5.insert(70);
        t5.insert(10);
        t5.insert(48);
        t5.insert(41);
        t5.insert(46);
        t5.insert(47);
        t5.insert(44);
        t5.insert(5);
        t5.insert(15);

        System.out.println("-------------------------");
        t4.printTree();
        System.out.println("-------------------------");
        t5.printTree();
        System.out.println("-------------------------");



        if (t5.equals(t4))
            System.out.println("Tree t4 equals tree t5");
        else
            System.out.println("Tree t4 doesn't equal tree t5");

        System.out.println("---------------------");
        if (t1.equals(t3))
            System.out.println("Tree t1 equals tree t3");
        else
            System.out.println("Tree t1 doesn't equal tree t3");

        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("Testing Case 1 - removing 44 and 47");
        t5.printTree();
        t5.remove(44);
        t5.remove(47);
        System.out.println("---------------------");
        t5.printTree();

        System.out.println("---------------------");
        System.out.println("Testing Case 2 - removing 20");
        t5.printTree();
        t5.remove(20);
        System.out.println("---------------------");
        t5.printTree();

        System.out.println("---------------------");
        System.out.println("Testing Case 3 - removing 41");
        t5.printTree();
        t5.remove(41);
        System.out.println("---------------------");
        t5.printTree();

        System.out.println("---------------------");
        System.out.println("Testing Case 4 - removing 60");
        t5.printTree();
        t5.remove(60);
        System.out.println("---------------------");
        t5.printTree();

        // Test removing the root
        //
        t6.insert(6);
        System.out.println("Case one, the root is a leaf node");
        t6.printTree();
        t6.remove(6);
        System.out.println("---------------------");
        t6.printTree();

        t7.insert(6);
        t7.insert(5);
        System.out.println("Case two, the root ...");
        t7.printTree();
        t7.remove(6);
        System.out.println("---------------------");
        t7.printTree();

        t8.insert(6);
        t8.insert(7);
        System.out.println("Case three, the root ...");
        t8.printTree();
        t8.remove(6);
        System.out.println("---------------------");
        t8.printTree();

        t9.insert(6);
        t9.insert(5);
        t9.insert(7);
        System.out.println("Case four, the root ...");
        t9.printTree();
        t9.remove(6);
        System.out.println("---------------------");
        t9.printTree();

        System.exit(0);
        // Here we test findMax() and findMin() - Note: this code
        // fails if the tree is empty and null is returned.

        System.out.println("\nt1 max is " + t1.findMax().toString());
        System.out.println("\nt2 max is " + t2.findMax().toString());

        System.out.println("\nt1 min is " + t1.findMin().toString());
        System.out.println("\nt2 min is " + t2.findMin().toString());

        // Test removeMin) and removeMax()
        // After each removal print the tree.

        t1.removeMin();
        System.out.println("---------------------");
        t1.printTree();

        t1.removeMin();
        System.out.println("---------------------");
        t1.printTree();

        t1.removeMin();
        System.out.println("---------------------");
        t1.printTree();

        t1.removeMax();
        System.out.println("---------------------");
        t1.printTree();

        t1.removeMax();
//        System.out.println("---------------------");
//        t1.printTree();
//
//        t1.removeMax();
//        System.out.println("---------------------");
//        t1.printTree();


        // Add your own checks, trees, and removals
        // so that all cases are handled and tested.


//        t1.remove(47);
//        System.out.println("---------------------");
//        t1.printTree();

//        t1.remove(50);
//        System.out.println("---------------------");
//        t1.printTree();
//
//        t1.remove(20);
//        System.out.println("---------------------");
//        t1.printTree();
//
//        t1.remove(60);
//        System.out.println("---------------------");
//        t1.printTree();
//
//        t1.remove(40);
//        System.out.println("---------------------");
//        t1.printTree();
//
//        t1.remove(70);
//        System.out.println("---------------------");
//        t1.printTree();


    }

}
