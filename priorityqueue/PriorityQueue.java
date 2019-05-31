import java.util.*;

class PriorityQueue <T extends Comparable<T>>
                        implements PriorityQueueInterface<T>

{
	private Node headSentinel;
	private Node tailSentinel;
	private int size;

	private class Node
    {
        public T data;      // Data stored in the Node.
        public Node next;   // Pointer to next Node in the list.
		public Node prev;
    }

	private Node newNode (T d) //makes a new node
	{
		Node temp = new Node();
		temp.data = d;
		temp.next = null;
		temp.prev = null;
		size++;

		return temp;
	}

	public PriorityQueue() //sets up an empty priority queue
	{
		headSentinel = newNode(null); //first sentinel - head, no data
		headSentinel.prev = null;

		tailSentinel = newNode(null); //last sentinel - last item, no data
		tailSentinel.prev = headSentinel;
		headSentinel.next = tailSentinel;

		size = 0;
	} 

	public void enqueue(T d)
	{
		Node start = headSentinel.next;
		T startdata = start.data;		

		Node temp = newNode(d);
		T tempdata = temp.data;		

		while (start.next != null && start.data.compareTo(temp.data) >= 0) //while the traversal node has higher priority
		{
			start = start.next;
		}

		//exit the loop when temp's priority is greater than start
		//I used less than equal to to avoid starvation

		temp.prev = start.prev; //links node to node before start 
		temp.next = start; //forward link from node to start
		start.prev.next = temp; //links node before start to node
		start.prev = temp; //backward link from node to start

		size++; 
	}

	public T dequeue()
	{
		Node temp = headSentinel.next; //holds front item
		headSentinel.next = headSentinel.next.next; 
		temp.next.prev = headSentinel;
		//moves the front item to the item after the front	
	
		size--;
		return temp.data;
	}

	public T front()
	{
		Node temp = headSentinel.next;

		return temp.data; //returns whatever data is in the front item
	}
	
	public boolean isEmpty()
	{
		return (headSentinel.next == tailSentinel)?true:false;
		//returns T if there is no first data item
		//F if there is a first data item
	}
	
	public boolean isFull()
	{
		return false; //priority queue is never full in our implementation?
	}

	public String toString()
	{
		String str = "";

		str += "The queue: ";
		str += "Head: \n";

		Node ptr = headSentinel.next;
	
        while (ptr != tailSentinel)
		{   
            T data = ptr.data;            
            str += (data.toString() + "\n"); 
            ptr = ptr.next;                 
        }
		str += "^ the tail ^\n";
        
		return str;
	}
}
