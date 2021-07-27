package hard;

import java.util.Stack;

public class Q32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else if(s.charAt(i) == ')'){
                stack.pop();
                if(!stack.empty()){
                    int n = stack.peek();
                    res = Math.max(res, i - n);
                }
                else{
                    stack.push(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = ")()())";
        Q32 q = new Q32();
        System.out.println(q.longestValidParentheses(s));
    }
}
