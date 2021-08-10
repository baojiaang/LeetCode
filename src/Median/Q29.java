package Median;

public class Q29 {
    public int divide(int dividend, int divisor) {
        //--------处理越界-------
        long res = 0;

        //--------处理正负-------
        int flag = 1;
        if(dividend < 0) flag *= -1;
        if(divisor < 0) flag *= -1;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        //--------优化时间复杂度-------
        while(a >= b){
            long temp = b;
            long i = 1;
            while(a >= temp){
                res += i;
                a -= temp;
                i <<= 1;
                temp <<= 1;
            }
        }
        return res > Integer.MAX_VALUE ? flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : (int)res * flag;
    }

    public static void main(String[] args) {
        Q29 q = new Q29();
        System.out.println(q.divide(-2147483648,1));
    }
}
