package Median;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Q313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.add(1L);
        int ugly = 1;
        for(int i = 0; i < n; i++){
            long cur = pq.poll();
            ugly = (int)cur;
            for(int j = 0; j < primes.length; j++){
                if(set.add(cur*primes[j])){
                    pq.add(cur*primes[j]);
                }
            }
        }
        return ugly;
    }
}
