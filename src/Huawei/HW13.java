package Huawei;
import java.util.*;
public class HW13 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        while(sc.hasNext()){
            String s = sc.next();
            stack.push(s);
        }
        while(!stack.empty()){
            String s = stack.pop();
            System.out.print(s+" ");
            
        }
    }
}
