package Median;

import java.util.Stack;

public class Q946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++){
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek() == popped[j]){
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }
}
