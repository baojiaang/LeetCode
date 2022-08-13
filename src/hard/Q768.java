package hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q768 {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }
            else{
                if(arr[i] >= stack.peek()){
                    stack.push(arr[i]);
                }
                int last = stack.pop();
                while(!stack.isEmpty() && stack.peek() > arr[i]){
                    stack.pop();
                }
                stack.push(last);
            }
        }
        return stack.size();
    }
}
