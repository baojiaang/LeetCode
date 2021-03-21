package Median;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    Stack<Integer> s = new Stack<>();
    public int evalRPN(String[] tokens) {
        int res = 0;
        for(int i = 0;i < tokens.length; i++){
            String val = tokens[i];
            if(val.equals("+")){
                s.push(compute(1));
            }
            else if(val.equals("-")){
                s.push(compute(2));
            }
            else if(val.equals("*")){
                s.push(compute(3));
            }
            else if(val.equals("/")){
                s.push(compute(4));
            }
            else{
                s.push(Integer.parseInt(val));
            }
        }
        return s.pop();
    }
    public int compute(int op_code){
        int a = s.pop();
        int b = s.pop();
        switch (op_code){
            case 1:
                return b+a;
            case 2:
                return b-a;
            case 3:
                return b*a;
            case 4:
                return b/a;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] test = {"4","13","5","/","+"};
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        e.evalRPN(test);
    }
}
