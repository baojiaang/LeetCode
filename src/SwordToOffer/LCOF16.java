package SwordToOffer;
/*
*  快速幂，将n理解为二进制，&1取最低位，为1则乘上对应的x的n次
* */
public class LCOF16 {
    public double myPow(double x, int n) {
        double res = 1;
        long nn = n;
        if(n < 0){
            x = 1 / x;
            nn = -nn;
        }
        if(n == 0)
            return 1;
        if( x == 1)
            return 1;
        while(nn > 0){
            if((nn & 1) != 0)
                res = res * x;
            x *= x ;
            nn >>= 1;
        }
        return res;
    }
}
