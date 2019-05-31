/*
 *   class QueueCirc
 *   
 *   A Circular Implementation of the generic QueueInterface.
 */

import java.util.Arrays;

@SuppressWarnings("unchecked")

public class QueueCirc<T> implements QueueInterface<T>
{

	private int front;   // Index of the front item in the queue.
	private int rear;   // Index of the rear item in the queue.
	private int currentSize; //index of the size of the queue	

	private T[] QueueCirc;  // Generic arrays cannot be constructed in Java.
	                                       // A solution is to create an array of Object
	                                       // and type cast as an array of a generic type.
	                                       // Ignore any warnings the compiler generates.
	/*
	 *    The Queue constructor.
	 */
	
	public QueueCirc()
	{
		QueueCirc = (T[])new Object[20];
		front = -1;
		rear = -1;
		currentSize = 0;
	}

	/*
	 *    enqueue() - add an item to the rear of the queue.
	 *                Do nothing if the queue is full.
	 */
	
	public void enqueue(T item)
	{
		if (isFull())
		{
			System.out.println("Queue is full");
			return; //exit function
		}

		rear = (rear+1) % QueueCirc.length; 
		//adds to the tail + puts it where the tail
		//will be if the queue needs to wrap around
		
		QueueCirc[rear] = item;

		currentSize++;

		if (front == -1) //in case the front is out of bounds
		{
			front++; 
		} 
	}
	
    /*
     *   dequeue() - delete and return the front item
     *               in the queue. Return null if 
     *               the queue is empty.
     */
	
	public T dequeue()
	{
		if (isEmpty())
		{
			System.out.println("Empty queue");
			return null; //exit the function
		}
		
		T dequeued = QueueCirc[front]; //the item to be dequeued is in front
		QueueCirc[front] = null; //the element is now removed from the queue

		front = (front + 1) % QueueCirc.length; //the head can now wrap around
		//to wherever the next "front item" is
		
		currentSize--; //decrease the size of the queue

		return dequeued;
	}
	
	/*
	 *    front() - Return (but do not delete) the item
	 *              at the front of the queue.
	 */
	
    public T front()
    {
    	return QueueCirc[front];
    }
    
    /*
     *    isEmpty() - returns true if the queue is empty 
     *                else returns false.
     */
    
    public boolean isEmpty()
    {
    	if (currentSize == 0)
		{
			return true;
		}
		return false;
    }
    
    /*
     *    isFull() - returns true if the queue is empty 
     *               else returns false.
     */
    
    public boolean isFull()
    {
    	if (currentSize == QueueCirc.length) //if the queue  size is the same as the total array length
		{
			return true;
		}
		return false;
    }
    
    /*
     *  toString() - return a printable display of
     *               the items in the queue.
     */
    
    public String toString()
    {

    	return "Circular Queue: " + Arrays.toString(QueueCirc) + "\n" + " Front: " + front + " Rear: " + rear;
    }
}
