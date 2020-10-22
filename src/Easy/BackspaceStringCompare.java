package Easy;
/*
* 方法一：栈
* 方法二：双指针，逆序遍历
* 一个指针记录退格符，如果是退格符，skip+1
* 如果不是退格符，skip>0时，skip-1，当前要删去，
* 一个指针记录当前在哪个字符
* */
import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        boolean flag = true;
        Stack<Character> s1 = new Stack();
        Stack<Character> s2 = new Stack<>();
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c != '#'){
                s1.push(c);
            }
            else{
                if(!s1.empty()){
                    s1.pop();
                }
            }
        }
        for(int i=0;i<T.length();i++){
            char c = T.charAt(i);
            if(c != '#'){
                s2.push(c);
            }
            else{
                if(!s2.empty()){
                    s2.pop();
                }
            }
        }
        if(s1.size()!=s2.size()){
            return false;
        }
        while(!s1.empty()&&!s2.empty()){
            char c1 = s1.pop();
            char c2 = s2.pop();
            if(c1!=c2){
                flag = false;
                return flag;
            }
        }
        return flag;
    }
}
