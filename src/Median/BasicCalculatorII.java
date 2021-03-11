package Median;

import hard.BasicCalculator;

import java.util.*;

public class BasicCalculatorII {
    public int calculate(String s){
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+'; // 前一个符号
        int num = 0;
        int n = s.length();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
                num = num * 10 + (c - '0');
            if(!Character.isDigit(c) && c !=' ' ||  i == n-1){
                switch (preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                preSign = c;
                num = 0;
            }
            System.out.println(preSign);
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        String s = "3+2*2";
        basicCalculatorII.calculate(s);
    }
}
