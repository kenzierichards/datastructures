/*
 *    A program to decode a file using Huffman Code Algorithm.
 */

import java.io.*;

public class HDecode {
	
	private Node root = null;      // Root of the Huffman Code Tree.
	
	private String inputFilename;
	private int fileSize;          // The number of bytes 
	                               // in the original file.

	private BitReader bitr;
	private FileOutputStream outF = null;
	
	public static void main(String[] args)
			throws FileNotFoundException, IOException
	{
	
		if (args.length != 1) {
            System.out.println("Incorrect program argument");
            System.exit(0);
        }
	
		HDecode decoder = new HDecode(args[0]);  // Construct a Huffman Decoder
		decoder.decode();
		decoder.readTree();
	}

	public HDecode(String inputFilename)
	{
		this.inputFilename = inputFilename;
	}
	
	
	public void decode()
	{
		
		try {
            outF = new FileOutputStream(inputFilename+".orig");  // Open the input file.
			bitr = new BitReader(inputFilename);	

			int size = bitr.readInt();		
			
			for (int i = 0; i < size; i++)
			{
				Node n = readTree();
				if (n.lchild == null && n.rchild == null)
				{
					int origData = n.data;
					outF.write(origData);
				}
			}				
	
            outF.close();                  //  Close the file. 
			bitr.close();

        }
        catch (FileNotFoundException e) {
            System.out.printf("Error opening file %s\n", inputFilename);
            System.exit(0);
        }
        catch (IOException e) {
            System.out.printf("IOException reading from: %s\n", inputFilename);
            System.exit(0);
		}
		return;
	}
	
	
	public Node readTree()
	{	
		int b = bitr.readBit();

		if (b == 0) //leaf node
		{
			byte newData = (byte) bitr.readByte();
			Node nIf = new Node();
			nIf.data = newData;
			nIf.lchild = null;
			nIf.rchild = null;
			
			return nIf;	
		}
		else //intermediary node
		{
			Node lTree = new Node();
			Node rTree = new Node();
	
			lTree = readTree(); //left subtree
			rTree = readTree(); //right subtree

			Node nodeElse = new Node();
			nodeElse.lchild = lTree;
			nodeElse.rchild = rTree;
			lTree.parent = nodeElse;
			rTree.parent = nodeElse;
			
			return nodeElse;
		}
	}
			
	public class Node implements Comparable<Node>
	{
		byte data;           // A byte of data - stored in an Integer.
		Node lchild;         // Left child pointer.
		Node rchild;         // Right child pointer.
		Node parent;         // Pointer to parent node.
		Integer frequency;   // Frequency the data within
		                     // a file being encoded.
		/*
		 *   Basic node constructor.
		 */
		
		public Node()
		{
			data = 0;          // Each Huffman Code Tree node
			lchild = null;     // contains data, pointers to
			rchild = null;     // children and parent nodes
			parent = null;     // plus a frequency count
			frequency = 0;     // associated with the data.
		}
		
		
		/*
		 *   Constructor specifying all values
		 *   of the node instance variables.
		 */
		
		public Node(byte data, Node lchild, Node rchild,
				               Node parent, int frequency)
		{
			this.data = data;
			this.lchild = lchild;
			this.rchild = rchild;
			this.parent = parent;
			this.frequency = frequency;
		}
		
		
		/*
		 *    compareTo() - Compare two frequency values.  We want Nodes
		 *                  with lower frequencies to have higher priority
		 *                  in the priority queue.
		 *                  
		 */
		
		public int compareTo(Node other)
		{
          if (this.frequency < other.frequency)
			{
				return 1;
			} 
		  else if (this.frequency > other.frequency)
			{
				return -1;
			}
		  else
			{
				return 0;
			}
		}
		
		public String toString()
		{
			char ch = (char) this.data;
			
			String str = "byte: " + data + "  char: ";
			
			if (data > (byte) 31)
				str = str + (char) data + "  freq: " + frequency;
			else
				str = str + " " + "  freq: " + frequency;
			
			return str;
		}
		
	}
}
