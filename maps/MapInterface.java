//a generic interface for the implementation of a map
//K is the type of Key, V is the type of the Value

public interface MapInterface <K, V>
{
	public int getSize(); //number of keys currently stored
	public void makeEmpty(); //remove all items from map
	public void insert(K key, V value); //add key and value, if key is present override value
	public void remove(K key); //remove key and value if found, otherwise do nothing
	public V getValue(K key); //return value of item with given key, else null
	public boolean isEmpty(); //return true if empty
	public String toString(); //printable display of key/value pairs
	public String toStringBkw();
}
