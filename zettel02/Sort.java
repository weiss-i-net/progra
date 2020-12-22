import java.util.*;
import java.util.function.*;

public class Sort {

    public static void main(String[] args) {
        Random rand = new Random(System.currentTimeMillis());
         for (int i = 0; i < 10000; i++) {
            int length = rand.nextInt(10);
            int[] a = new int[length];
            for (int j = 0; j < length; j++) {
                a[j] = rand.nextInt(20);
            }
            BubbleSort.sort(a);
            int[] b = Arrays.copyOf(a, length);
            Arrays.sort(b);
            check(Arrays.equals(a, b), Arrays.toString(a) + " sollte " + Arrays.toString(b) + " sein.");
        }
         System.out.println("Alle Checks bestanden");
    }

    private static void check(boolean b, String m) {
        if (!b) {
            System.out.println("ERROR: " + m);
            System.exit(-1);
        }
    }

}
