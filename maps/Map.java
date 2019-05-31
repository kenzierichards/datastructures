//Kenzie Richards
//an implementation of the Map interface
//doubly linkded list implementation is used
//front and rear sentinel nodes are used
//note: I had to research how to use equals() with linked lists (data.equals())

public class Map <K, V> implements MapInterface<K, V>
{
	private Node header; //pointer to first item in Map

	public Map()
	{
		Node front = new Node(); //front sentinel
		Node rear = new Node(); //rear sentinel

		front.prev = null; 
		front.next = rear; //links front to rear sentinel
		rear.prev = front; //links rear to front sentinel
		rear.next = null;
		
		//all map items will be in between the sentinels
		
		header = front; //sets header to point to front node
	}

	public int getSize()
	{
		int i = 0;

		Node ptr = header; //sets pointer to start of the list

		while (ptr != null)
		{
			i++; //count the number of nodes
			ptr = ptr.next; //move the pointer
		} 
		
		return i-2; //returns count
	}

	public void makeEmpty()
	{
		Node ptr = header; //set pointer to start of list

		//makes second node rear sentinel
		header.next.next = null; //makes the next link null
		header.next.key = null; //removes key
		header.next.value = null; //removes value

		//garbage collection takes care of rest
	}

	public void insert(K key, V value)
	{      			
		Node ptr = header.next; //starts at first data item (past front sentinel)
		
		while (ptr.next != null) //while not at the rear sentinel
		{
			if (ptr.key.equals(key)) //key exists
			{
				ptr.value = value;
				return;
			}
			ptr = ptr.next; //traverse list
		}
		
		Node newNode = new Node(); //makes a new node
		newNode.value = value;
		newNode.key = key;

		newNode.next = header.next;
		header.next = newNode;
		newNode.prev = header;
		newNode.next.prev = newNode;
	}

	public void remove(K key)
	{
		Node ptr = header; //traverses list
		Node prev = null;

		while (!ptr.key.equals(key)) //the list has not reached the key yet
		{
			prev = ptr; //moves the prev pointer to the next pointer
			ptr = ptr.next; //moves traversal  pointer to the next pointer
		}

		//here, the pointer will reach the item with the key
		prev.next = ptr.next; //removes link from the data to list
		
	}

	public V getValue(K key)
	{
		Node temp = header;
		V val = null;

        while (temp.next != null)
        {
            temp = temp.next;

			if (temp.key.equals(key))
			{
				val = temp.value;
			}
        }
		return val;
	}

	public boolean isEmpty()
	{
		return (header.next.next == null);
		//if the next node doesn't point to anything (rear sentinel), the list is empty
	}

	//returns String representation of map
	public String toString()
	{
		String str = "The Map\n--------------\n";
		Node ptr = header.next; 

		while (ptr.next != null)
		{
			str = str + "key: ";
			str = str + ptr.key.toString();
			str = str + "     ";
			str = str + "value: ";
			str = str + ptr.value.toString();
			str = str + "\n";
			ptr = ptr.next;
		}

		str = str + "--------------\n";

		return str;
	}


	public String toStringBkw()
    {
        String str = "The Map - yet again\n--------------\n";
        
        Node ptr = header.next;
  
        while (ptr.next != null)  // Find the rear sentinel
            ptr = ptr.next;
        ptr = ptr.prev;     // Point to node before rear sentinel
        
        while (ptr.prev != null) {             // Create a String consisting
            str = str + "key: ";               // of all the (key, value)
            str = str + ptr.key.toString();    // pairs - return this String 
            str = str + "   ";                 // as the value of the function.
            str = str + "value: ";
            str = str + ptr.value.toString();
            str = str + "\n";
            ptr = ptr.prev;
        }
        
        str = str + "--------------\n";
        
        return str;
    }

	private class Node
	{
		public K key; //item key
		public V value; //item value
		public Node prev; //pointer to previous node
		public Node next; //pointer to next node
	}
}
