import java.util.*;

public class MaxPQBinaryHeap<Key extends Comparable<Key>> {
    private List<Key> pq;

    public MaxPQBinaryHeap(){
        pq = new ArrayList<>();
    }

    public boolean isEmpty(){
        return pq.isEmpty();
    }

    /**
     * Add node at end, then swim it up
     * @param key
     */
    public void insert(Key key){
        pq.add(key);
        swim(pq.size());
    }

    /**
     * Exchange root with node at end, then sink it down
     * @return
     */
    public Key delMax(){
        Key max = pq.get(0);
        exch(0, pq.size());
        sink(0);
        return pq.remove(pq.size()-1);
    }

    /**
     * Exchange key in child with key in parent
     * Repeat until heap is restored
     * @param k
     */
    private void swim(int k){
        while (k > 1 && less(k/2,k)){
            exch(k, k/2);
            k /= 2;
        }
    }

    /**
     * Exchange key in parent with key in larger child (demotion)
     * Repeat until heap order restored
     * @param k
     */
    private void sink(int k){
        while (2 * k < pq.size()){
            int j = 2 * k;
            if (j < pq.size() && j < j + 1){ // children of node at 2k and 2k+1
                j++;
            }
            if (!less(k,j))
                break; // case: if the child is less than the parent we have found the right spot so stop sinking
            exch(k, j);
            k = j;
        }
    }

    private void exch(int a, int b){
        Key temp = pq.get(a);
        pq.set(a, pq.get(b));
        pq.set(b, temp);
    }

    private boolean less(int a, int b){
        return pq.get(a).compareTo(pq.get(b)) < 0;
    }
}
