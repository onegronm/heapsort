import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of a PQ is to return the largest (or smallest) item inserted
 * The M largest (or smallest) items can be obtained through the client code
 * When pq.size() > M, then pq.delMin() (for largest) or pq.delMax(for smallest)
 *
 * Cheap version where we require the client to provide a capacity but we could easily changes to resizing an array or linked list.
 * Goes through the entire array to find the maximum and exchange it with the one in the end and remove it as we would in a stack.
 * Fine implementation if the priority queue is going to be tiny all the time.
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private List<Key> pq; // pq[i] = ith element on pq

    // unordered PQ
    // insert 1
    // del max N
    // max N
    // if array is kept sorted with each insert (ordered) then del max and max are constant but insert is linear
    // find largest M items -> M * N

    /**
     * Create an empty priority queue
     */
    public MaxPQ(int capacity) {
        pq = new ArrayList<>();
    }

    /**
     * Create a priority queue with given keys
     * @param a
     */
    public MaxPQ(Key[] a){

    }

    /**
     * Insert a key into the priority queue
     * @param v
     */
    public void insert(Key v){
        pq.add(v);
    }

    /**
     * Return and remove the largest key
     * @return
     */
    public Key delMax(){
        int max = 0;
        for(int i = 1; i < pq.size(); i++){
            if(max < i) max = i;
        }
        exch(max, pq.size()-1);
        return pq.remove(pq.size()-1);
    }

    /**
     * Is the priority queue empty?
     * @return
     */
    public boolean isEmpty(){
        return pq.isEmpty();
    }

    /**
     * Return the largest key
     * @return
     */
    public Key max(){
        int max = 0;
        for(int i = 1; i < pq.size(); i++){
            if(max < i) max = i;
        }
        exch(max, pq.size()-1);
        return pq.get(pq.size()-1);
    }

    /**
     * Number of entries in the priority queue
     * @return
     */
    public int size(){
        return pq.size();
    }

    private void exch(int a, int b){
        Key temp = pq.get(a);
        pq.set(a, pq.get(b));
        pq.set(b, temp);
    }
}
