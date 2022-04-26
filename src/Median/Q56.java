package Median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(int[] a1, int[] a2) -> (a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]));
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(!stack.empty()){
                int[] pre = stack.peek();
                if(cur[0] <= pre[1]){
                    if(cur[1] >= pre[1]){
                        pre[1] = cur[1];
                        stack.pop();
                        stack.push(pre);
                    }
                }
                else{
                    stack.push(cur);
                }
            }
            else{
                stack.push(cur);
            }
        }
        int[][] ret = new int[stack.size()][2];
        int index = 0;
        for(int[] interval : stack){
            ret[index] = interval;
            index++;
        }
        return ret;
    }

    public static void main(String[] args) {
        Q56 q = new Q56();
        int[][] test = {{1,10},{1,4}};
        System.out.println(q.merge(test));
    }
}
