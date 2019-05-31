
/*
 *    A comparison of iterative vs recursive
 *    binary search algorithms. Requires a sorted array.
 */

import java.util.*;

public class BinarySearch {

    private static int[] A = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

    public static void main(String[] args)
    {
        int key;       //integer to search for
        int index1;    //location of the key if it's in the array - iterative.
        int index2;    //location of the key if it's in the array - recursive.

        Scanner keyb = new Scanner(System.in);

        do {
            System.out.print("\nEnter an integer to search for (0 to quit): ");
            key = keyb.nextInt();

            index1 = SearchBinIterative(A, key, 0, A.length-1);
            index2 = SearchBinRecursive(A, key, 0, A.length-1);

            if (index1 != index2)
                System.out.println("indices don't match!!");
            else
                System.out.printf("index1: %d, index2 %d\n",index1, index2);

            if (index1 != -1)
                System.out.printf("%d was found at index %d\n", key, index1);
            else
                System.out.printf("%d is not in the array", key, args);

        } while (key != 0);
    }

    /*
     *   SearchBinIterative()
     *
     *   Search for the key within the array A from location left to right.
     *   Return the index where it is found or -1.
     */

    public static int SearchBinIterative(int[] A, int key, int left, int right)
    {
        int mid = 0;               //index at middle of search region
        boolean found = false;    

        while (left <= right && !found) 
			{                                 
            	mid = (left + right) / 2;       // compute middle of SR

            	if (A[mid] == key)              // we found the key
                	found = true;               //    set our flag
            	else if (key < A[mid])          // key less than middle
                	right = mid-1;              //    search left side of SR
            	else                            // key greater tham middle
                	left = mid + 1;             //    search right side of SR
        	}

        return found ? mid : -1;    // Return index or -1.
    }

    /*
     *   SearchBinRecursive()
     *
     *   Search for the key within the array A from location i to j.
     *   Return the index where it is found or -1.
     */

    public static int SearchBinRecursive(int[] A, int key, int left, int right)
    {
		int mid = 0;

        if (right >= left) 
		{
			mid = (right - left) + 1 / 2; //keeps shifting the middle point each time it recurses			
		
			if (A[mid] == key) //if the key is the midpoint
			{
				return mid;
			}

			if (A[mid] > key) 
			{
				return SearchBinRecursive(A, key, left, mid-1);
			}
		
			return SearchBinRecursive(A, key, mid+1, right);
    	}

	   return -1;
	}
}
