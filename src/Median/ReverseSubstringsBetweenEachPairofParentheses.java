package Median;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {
    public String reverseParentheses(String s) {
        Deque<Character> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != ')') {
                queue.addLast(c);
            }
            else if(c == ')'){
                StringBuilder sb = new StringBuilder();
                char out = queue.pollLast();
                while( out != '('){
                  sb.append(out);
                  out = queue.pollLast();
                }
                for(char in : sb.toString().toCharArray()){
                    queue.addLast(in);
                }
            }
        }
        while(!queue.isEmpty()){
            res.append(queue.pollFirst());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairofParentheses r = new ReverseSubstringsBetweenEachPairofParentheses();
        System.out.println(r.reverseParentheses("\"a(bcdefghijkl(mno)p)q"));
    }
}
