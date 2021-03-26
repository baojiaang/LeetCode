package Median;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> s = new Stack<>();
        List<Integer> result = new ArrayList<>();
        int second = Integer.MIN_VALUE;
        if(nums.length < 3 )
            return false;
        for(int i = nums.length - 1; i>= 0; i--){
            if(nums[i] < second)
                return true;
            while(!s.empty() && s.peek() < nums[i])
                second = s.pop();

            s.push(nums[i]);
        }
        return false;
    }
}
