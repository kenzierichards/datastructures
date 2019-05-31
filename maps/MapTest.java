/*
 *   A test program to exercise the
 *   functionality of the Map class.
 */

public class MapTest
{
    
    public static void main(String[] args)
    {
        // Create two Maps

        Map<String, Integer> m = new Map<String, Integer>();
        Map<Integer, Double> nums = new Map<Integer, Double>();

        // Create some Strings to insert into a Map
        
        String csi1 = new String("CSI 111");
        String csi2 = new String("CSI 111");
        String csi3 = new String("CSI 111");
        String mth1 = new String("MTH 121");
        String bio1 = new String("BIO 140");
        String chm1 = new String("CHM 102");

        // Insert <String, Integer> Items into the Map
        
        m.insert(csi1, new Integer(16));
        m.insert(mth1, new Integer(24));
        m.insert(bio1, new Integer(16));
        m.insert(csi2, new Integer(21));

        // Display the Map and its size.

        System.out.printf("Map size: %d\n", m.getSize());        
        System.out.println(m.toString());
        System.out.printf("Map size: %d\n", m.getSize());
        
        // Get the values of some Map items.

        Integer n = m.getValue(csi3);
        
        System.out.println("just called getValue");
        if (n != null)
            System.out.println(n.toString());
        else
            System.out.println("n is null");
        
        n = m.getValue("CSI 555");
        
        if (n != null)
            System.out.println(n.toString());
        else
            System.out.println("n is null");        
        
        // Insert a new item in the Map

        m.insert(chm1, 42);
        System.out.println(m.toString());
        System.out.printf("Map size: %d\n", m.getSize());

        m.insert(mth1, 45);
        System.out.println(m.toString());
        System.out.printf("Map size: %d\n", m.getSize());
        
        m.remove("MTH 121");
        System.out.println(m.toString());
        System.out.printf("Map size: %d\n", m.getSize());       

        // Exercise the isEmpty() method.
        if (m.isEmpty())
            System.out.println("m is empty");
        else
            System.out.println("m is not empty");

        if (nums.isEmpty())
            System.out.println("nums is empty");
        else
            System.out.println("nums is not empty");

        // Now exercise the nums Map
        
        nums.insert(new Integer(1), 1.8);
        nums.insert(new Integer(2), 2.5);
        nums.insert(new Integer(3), 3.8);
        nums.insert(new Integer(4), 4.5);
        nums.insert(new Integer(5), 5.8);
        nums.insert(new Integer(5), 6.5);

        System.out.println("\n\nMaking non-empty nums empty");
        nums.makeEmpty();
        System.out.println(nums.toString());
        System.out.printf("Map size: %d\n", nums.getSize());    
        System.out.println(nums.toStringBkw());
        System.out.println("Now put items back in nums\n\n");


        
        nums.insert(new Integer(1), 1.8);
        nums.insert(new Integer(2), 2.5);
        nums.insert(new Integer(3), 3.8);
        nums.insert(new Integer(4), 4.5);
        nums.insert(new Integer(5), 5.8);
        nums.insert(new Integer(5), 6.5);
        
        System.out.println(nums.toString());
        System.out.printf("Map size: %d\n", nums.getSize());
        
        nums.remove(1);
        
        System.out.println(nums.toString());
        System.out.printf("Map size: %d\n", nums.getSize());    

        nums.remove(9);

        System.out.println(m.toStringBkw());
        System.out.println(nums.toStringBkw());
         
    }
}
