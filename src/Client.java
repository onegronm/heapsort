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
    }
}
