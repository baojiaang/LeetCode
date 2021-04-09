package hard;
/*
* 单调栈
*
* */
import java.util.Stack;

public class VolumeofHistogramLCCI {
    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for(int i = 0; i < height.length; i++){
            while(!s.empty() && height[i] > height[s.peek()]){
                int top = s.pop();
                if(s.empty())
                    break;
                int left = s.peek();
                int width = i - left - 1;
                int h = Math.min(height[left],height[i]) - height[top];
                res += h * width;
            }
            s.push(i);
        }
        return res;
    }
}
