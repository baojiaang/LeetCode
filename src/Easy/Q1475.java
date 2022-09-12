package Easy;

import java.util.Stack;

public class Q1475 {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int[] ret = new int[prices.length];
        for(int i = prices.length - 1; i >= 0; i--){
            while(!s.isEmpty() && s.peek() > prices[i]){
                s.pop();
            }
            if(!s.isEmpty()){
                ret[i] = prices[i] - s.peek();
            }
            else{
                ret[i] = prices[i];
            }
            s.push(prices[i]);
        }
        return ret;
    }
}
