/*
 *   A program to implement a recursive function
 *   to sum the elements of an integer array.
 */

public class ArraySum
{
    private static int[] A = {};           //empty array
    private static int[] B = { 3, 5, 2 };
    private static int[] C = {2, -2, 2, -2, 2, -2, 5};


    public static void main(String[] args) {

        int sumA = sum(A, 0, (A.length)); //sum elements of each array
        int sumB = sum(B, 0, (B.length-1));
        int sumC = sum(C, 0, (C.length-1)); 

        System.out.printf("The sum for array A is %d\n", sumA); //print sums
        System.out.printf("The sum for array B is %d\n", sumB);
        System.out.printf("The sum for array C is %d\n", sumC);
    }


    /*
     *    sum() - return the sum of the elements in
     *            array X from index i to index j.
     */

    public static int sum(int[] x, int i, int j) 
    {
		if (i == x.length)
        {
			 return 0; //base case
		}
        else 
        {
			 return x[i] + sum(x, i+1, j); //recursive case -- make i closer to j so eventually reaches base
		}
    }

}
