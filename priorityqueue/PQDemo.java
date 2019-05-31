/*
 *    PQDemo - a program to test an implementation
 *             of a Priority Queue.
 */


public class PriorityQueueDemo2 {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<String>  strPQ = new PriorityQueue<String>();
        PriorityQueue<IntegerNode> intPQ = new PriorityQueue<IntegerNode>();
        PriorityQueue<Student> spq = new PriorityQueue<Student>();

        if (pq2.isEmpty())
            System.out.println("pq2 is empty as it shoud be");
        else
            System.out.println("pq2 is not empty! - but it should be");

        pq2.enqueue(5);
        System.out.println( pq2.toString() );
        Integer nn = pq2.dequeue();
        System.out.println("Dequeued: " + nn.toString());
        if (pq2.isEmpty())
            System.out.println("pq2 is empty as it shoud be");
        else
            System.out.println("pq2 is not empty! - but it should be");



        System.out.println("\n----------\n");


        pq.enqueue(6);
        pq.enqueue(8);
        pq.enqueue(3);
        pq.enqueue(7);
        pq.enqueue(2);
        pq.enqueue(10);
        pq.enqueue(1);
        pq.enqueue(5);

        System.out.println( pq.toString() );

        Integer i = pq.dequeue();
        System.out.println("Dequeued: " + i.toString());

        System.out.println( pq.toString() );

        strPQ.enqueue("Washington");
        strPQ.enqueue("Adams");
        strPQ.enqueue("Jefferson");
        strPQ.enqueue("Madison");
        strPQ.enqueue("Monroe");

        System.out.println( strPQ.toString() );

        intPQ.enqueue(new IntegerNode(6));
        intPQ.enqueue(new IntegerNode(8));
        intPQ.enqueue(new IntegerNode(3));
        intPQ.enqueue(new IntegerNode(7));
        intPQ.enqueue(new IntegerNode(2));
        intPQ.enqueue(new IntegerNode(10));
        intPQ.enqueue(new IntegerNode(1));
        intPQ.enqueue(new IntegerNode(5));

        System.out.println( intPQ.toString() );
        
        // Student priorities are determined by
        //     1st: lowest year
        //     2nd: Last name in alphabetical order
        spq.enqueue(new Student("Jones", "Mike",2018));
        spq.enqueue(new Student("Jones", "Sally",2015));
        spq.enqueue(new Student("Doe", "Barney",2016));
        spq.enqueue(new Student("Barnes", "John",2016));
        spq.enqueue(new Student("Cavett", "Fred",2016));
        spq.enqueue(new Student("Barnes", "Zoe",2016));
        spq.enqueue(new Student("Barnes", "Abby",2016));
       
        spq.enqueue(new Student("Smith", "Abby",2014));
        spq.enqueue(new Student("Barnes", "Abby",2019));
        
        System.out.println( spq.toString() );  // Display the queue.
    }
}
