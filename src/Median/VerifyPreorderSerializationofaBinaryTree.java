package Median;

import java.util.Stack;
import java.util.regex.Pattern;

public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if( preorder.equals("#"))
            return true;
        String[] preorderAfter = preorder.split(",");
        Stack<Integer> s = new Stack<>();
        s.push(1);
        for(int i = 0; i < preorderAfter.length; i++){
            String str = preorderAfter[i];
            if(isNumeric(str)){
                if(!s.empty()){
                    int n = s.pop();
                    n--;
                    if(n > 0)
                        s.push(n);
                }
                else
                    return false;
                s.push(2);
            }
            else{
                if(s.empty())
                    return false;
                int n = s.pop();
                n--;
                if(n > 0)
                    s.push(n);
            }
            System.out.println(str + " "+ s.size());
        }
        return s.empty();
    }
    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,#,2,#,6,#,#";
        VerifyPreorderSerializationofaBinaryTree v = new VerifyPreorderSerializationofaBinaryTree();
        System.out.println(v.isValidSerialization(s));;
    }
}
