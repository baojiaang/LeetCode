package Median;

import java.util.PriorityQueue;

public class Q646 {
    public int findLongestChain(int[][] pairs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for(int []pair: pairs){
            pq.add(pair);
        }
        int ret = 0;
        if(pq.size() == 0){
            return ret;
        }
        int last = pq.poll()[1];
        ret++;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0] > last){
                ret++;
                last = cur[1];
            }
        }
        return ret;
    }
}
