package Median;

import java.util.ArrayList;
import java.util.List;

public class Q592 {
    public String fractionAddition(String expression) {
        List<Integer> numList = new ArrayList<>();
        int base = 1;
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '/'){
                int num = expression.charAt(i+1) - '0';
                if(i + 2 < expression.length() && expression.charAt(i+2) == '0'){
                    num = num * 10;
                }
                numList.add(num);
                if(num > base){
                    if(num % base == 0){
                        base = num;
                    }
                    else{
                        base = base * num;
                    }
                }
                else{
                    if(base % num == 0){

                    }
                    else{
                        base *= num;
                    }
                }
            }
        }
        boolean first = true;
        int start = 0;
        List<Integer> l1 = new ArrayList<>();
        if(expression.charAt(0) == '-'){
            first = false;
            start = 1;
        }
        for(; start < expression.length(); start++){
            char c = expression.charAt(start);
            if(c == '/'){
                int num = expression.charAt(start-1) - '0';
                boolean flag = false;
                if(start - 2 >= 0 && expression.charAt(start-2) == '1'){
                    num = 10;
                    flag = true;
                }
                if(flag){
                    if(start - 3 >= 0 && expression.charAt(start-3) == '-'){
                        num = -num;
                    }
                }
                else{
                    if( start - 2 >= 0 && expression.charAt(start-2) == '-'){
                        num = -num;
                    }
                }
                int size = l1.size();
                num *= base / numList.get(size);
                l1.add(num);
            }
        }
        int numerator = 0;
        for(int num : l1){
            numerator += num;
        }
        int gcd = gcd(numerator,base);
        numerator /= gcd;
        base /= gcd;
        StringBuilder sb = new StringBuilder();
        sb.append(numerator);
        sb.append('/');
        sb.append(base);
        return sb.toString();
    }
    int gcd(int a, int b){
        int temp = b > a ? b : a;
        while(temp > 0){
            if(a%temp == 0 && b % temp == 0){
                break;
            }
            temp--;
        }
        return temp;

    }

    public static void main(String[] args) {
        Q592 q = new Q592();
        System.out.println(q.fractionAddition("-5/2+10/3+7/9"));
    }
}
