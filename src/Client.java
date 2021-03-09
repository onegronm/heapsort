import java.util.Random;

public class Client {
    public static void main(String[] args){
        // find the smallest M items in a stream of N items
        int M = 5;
        MaxPQ<Double> pq = new MaxPQ<>(M);

        for(int i = 0; i < 100; i++){
            pq.insert(Math.random());
            if(pq.size() > M){
                pq.delMax();
            }
        }

        Random rand = new Random();
        Integer[] numbers = new Integer[100];

        for(int i = 0; i < numbers.length; i++){
            int upperbound = 100;
            numbers[i] = rand.nextInt(upperbound);
        }

        Heap.sort(numbers);
        Heap.show(numbers);
    }
}
