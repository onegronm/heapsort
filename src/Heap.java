public class Heap {
    public static void sort(Comparable[] pq){
        int N = pq.length;

        // 1. create max-heap with all N keys using bottom-up method
        // start at k = N/2 which is the first parent starting from the bottom (the parent of the node k is in position k/2)
        for(int k = N/2; k >= 1; k--){
            sink(pq, k, N);
        }

        // 2. remove the maximum one at a time. Leave in array instead of nulling out
        int k = N;
        while (k > 1){
            exch(pq, 1, k);
            sink(pq, 1, --k);
        }
    }

    /**
     * Exchange key in parent with key in larger child (demotion)
     * Repeat until heap order restored
     * @param k
     */
    private static void sink(Comparable[] a, int k, int n){
        while (2 * k <= n){
            int j = 2 * k;
            if (j < n && less(a, j,j+1)){
                // children of node at 2k and 2k+1 positions
                j++;
            }
            if (!less(a, k, j)) break; // case: if the child is less than the parent we have found the right spot so stop sinking
            exch(a, k, j);
            k = j;
        }
    }

    private static void exch(Object[] a, int i, int j){
        Object swap = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = swap;
    }

    private static boolean less(Comparable[] a, int i, int j){
        return a[i-1].compareTo(a[j-1]) < 0;
    }

    // print array to standard output
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}