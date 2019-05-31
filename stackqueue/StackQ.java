
/*
 *    An implementation of the StackInterface using Queues.
 */

public class StackQ <T> implements StackInterface<T> {

    QueueCirc<T> q1 = new QueueCirc<T>();
    QueueCirc<T> q2 = new QueueCirc<T>();
	private T top;
	
	/*
	 *   push(item) - add item to the stack.  It is at
	 *                the front of the list.
	 */
	
	public void push(T item)
	{
		q2.enqueue(item);
		top = item;		

		while (!q1.isEmpty()) 
		{
			q2.enqueue(q1.dequeue()); //reverses order of stack items in the second queue
		}
		
		//swaps the queues so we don't have to keep track of which one holds the data
		QueueCirc<T> temp = q1;
		q1 = q2;
		q2 = temp;
	}                                    
	
	
	/*
	 *   pop() - remove the top item from the stack and
	 *           return it as the function value.
	 */
	
	public T pop()
	{		
		q1.dequeue();
		
		if (!q1.isEmpty())
		{
			top = q1.front();
		}

		return top;
	}
	
	/*
	 *   top() - return the top stack item.
	 */
	
	public T top()
	{
		return top; //I keep track of the top using a variable
	}
	
	/*
	 *    isEmpty() - return True if the stack is empty
	 *                otherwise return False.
	 */
	
	public boolean isEmpty()
	{
		return q1.isEmpty();
	}
	
	
	/*
	 *    isFull() - return True if the stack is full
	 *                otherwise return False.
	 */
	
	public boolean isFull()
	{
		return false; //is never full?
	}
	
}
