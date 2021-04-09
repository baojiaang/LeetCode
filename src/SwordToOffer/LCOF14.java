package SwordToOffer;



/*
* 贪心 尽可能取3
* */
public class LCOF14 {
    public int cuttingRope(int n) {
        long res = 1;
        if(n < 4){
            return n-1;
        }
        while(n > 4){
            res = (res * 3) % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }
}
