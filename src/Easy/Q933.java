package Easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q933 {

    Queue<Integer> queue;
    public void RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while(queue.peek() + 3000 < t){
            queue.poll();
        }
        return queue.size();
    }
}
