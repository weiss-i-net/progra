public class BubbleSort {
    public static void sort(int[] a) {
        boolean sorted = false;
        int temp;

        for (int j = a.length; j > 0 && !sorted; --j) {
            sorted = true;

            for (int i = 1; i < j; ++i)
                if (a[i-1] > a[i]) {

                    sorted = false;

                    temp = a[i-1];
                    a[i-1] = a[i];
                    a[i] = temp;

                }
        }
    }
}

