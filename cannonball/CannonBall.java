import java.util.Scanner;

/*
 *    A program that implements a recursive function
 *    to compute the number of cannon balls in
 *    a pyramid.
 */

public class CannonBall {


    public static void main(String[] args) {

        Scanner keyb = new Scanner(System.in);  
        int cannonBalls;                        //# cannonballs in pyramid
        int layers;                             //#layers in pyramid

        do {
            System.out.print("\nNumber of layers (-1 to quit): ");
            layers = keyb.nextInt();

            if (layers != -1) {
                cannonBalls = cannon(layers);  //determines # cannonballs
                System.out.printf("There are %d cannonballs in the %d layers.\n",
                                                          cannonBalls, layers);
            }
        } while (layers != -1);
    }


    public static int cannon(int n)
    {
		if (n == 0)
			return 0;
		else
		{
			return (n * n + cannon(n-1));
		}   
    }
}
