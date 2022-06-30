package Median;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Q1823 {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }
        while(queue.size() > 1){
            for(int i = 1; i < k; i++){
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Q1823 q1823 = new Q1823();
        System.out.println(q1823.findTheWinner(5,2));
    }
}
