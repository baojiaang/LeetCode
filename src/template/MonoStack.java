package template;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MonoStack {
    public List<Integer> nextGreaterElement(List<Integer> nums){
        List<Integer> result = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for(int i = nums.size()-1; i >= 0; i--){
            int num = nums.get(i).intValue();
            while(s.peek() < num){
                s.pop();
            }
            int res = s.empty() ? -1:s.pop();
            result.set(i,res);
            s.add(num);
        }
        return result;
    }
}
