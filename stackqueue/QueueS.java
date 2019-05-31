/*
 *   An implementation of the QueueInterface using stacks.
	 Assuming stacks can never be full. 
 */

public class QueueS<T> implements QueueInterface<T>
{
	//renamed stacks
	Stack<T> s1 = new Stack<T>(); 
	Stack<T> s2 = new Stack<T>();
	
	/*
	 *    The Queue constructor.
	 */
	
	public QueueS()
	{
		s1 = new Stack<T>(); //stack where input goes
		s2 = new Stack<T>(); //stack where output goes
	}

	/*
	 *    enqueue() - add an item to the rear of the queue.
	 *                Do nothing if the queue is full.
	 */
	
	public void enqueue(T item)
	{
		s1.push(item); //puts an item onto the inbox (main stack)
	}
	
    /*
     *   dequeue() - delete and return the front item
     *               in the queue. Return null if 
     *               the queue is empty.
     */
	
	public T dequeue()
	{
		if (s2.isEmpty()) //if the outbox is empty
		{
			while (!s1.isEmpty()) //while the inbox isn't empty
			{
				s2.push(s1.pop()); //effectively reverse order of the stack items
			}
		}

		return s2.pop(); //return the new TOS (the old bottom of stack)
	}
	
	/*
	 *    front() - Return (but do not delete) the item
	 *              at the front of the queue.
	 */
	
    public T front()
    {
    	if (s2.isEmpty()) 
		{
			while (!s1.isEmpty())
			{
				s2.push(s1.pop()); //reverses order of s1's items
			}
		}
		
		return s2.top(); //returns top of new stack
    }
    
    /*
     *    isEmpty() - returns true if the queue is empty 
     *                else returns false.
     */
    
    public boolean isEmpty()
    {
    	return (s1.isEmpty() && s2.isEmpty());
		//both stacks must be empty in order to count the queue as empty
    }
    
    /*
     *    isFull() - returns true if the queue is empty 
     *               else returns false.
     */
    
    public boolean isFull()
    {	
    	return false; //the stacks will never be full(?)
    }
    
    /*
     *  toString() - return a printable display of
     *               the items in the queue.
     */
    
    public String toString()
    {
    	String msg1 = s1.toString() + "\n";
		String msg2 = s2.toString() + "\n";	

		return msg1 + msg2;
    }
}

