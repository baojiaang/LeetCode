package Median;
/*
* Solution: the solution is very simple, but you need care about the test case, you should ignore the white spaces first and care about
* the "" case
* */
public class StringToInteger {
    public int myAtoi(String str) {
        double num=0;
        boolean positive=true;
        int i=0;
        for(;i<str.length();){
            if (str.charAt(i)==' ') {
                i++;
            }
            else
                break;
        }
        str=str.substring(i);
        if(str.length()==0)
            return 0;
        char first=str.charAt(0);
        if(!isNum(first)){
            if(first=='+');
            else if(first=='-'){
                positive=false;
            }
            else
                return 0;
            String temp=str.substring(1);
            num=extract(temp);
        }
        else
            num=extract(str);
        if(positive){
            if(num>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(num<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return (int)num;
        }
        else{
            if(num<Integer.MIN_VALUE)
                return -Integer.MIN_VALUE;
            else if(num>Integer.MAX_VALUE)
                return -Integer.MIN_VALUE;
            else
                return -(int) num;
        }
    }
    boolean isNum(char c){
        if(c>='0'&&c<='9')
            return true;
        else
            return false;
    }
    double extract(String str){
        double number=0;
        for(int i=0;i<str.length();i++){
            if(isNum(str.charAt(i))) {
                int digit = str.charAt(i) - '0';
                number = number * 10 + digit;
            }
            else
                break;
        }
        return number;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger=new StringToInteger();
        System.out.println(stringToInteger.myAtoi(" 11"));
    }
}
