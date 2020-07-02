package Easy;

public class ReverseInteger {
    /*Description:Given a 32-bit signed integer, reverse digits of an integer.
    * My Solution:
    * compute the mod value from x and add the temp result times 10
    *
    * */
    public int reverse(int x) {
        int max=0x7fffffff,min=0x80000000;
        double n=0;
        for(;x!=0;n=n*10+x%10,x/=10);
        if(n>max||n<min)
            return 0;
        else
            return (int)n;

    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger=new ReverseInteger();
        System.out.println(reverseInteger.reverse(1534236469));
    }
}
