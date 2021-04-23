package Median;

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        for(int i = 1; i < n; i++){
            dp[i] = min(dp[i1] * 2, dp[i2] * 3, dp[i3] * 5);
            if(dp[i] == dp[i1] * 2){
                i1++;
            }
            if(dp[i] == dp[i2] * 3){
                i2++;
            }
            if(dp[i] == dp[i3] * 5){
                i3++;
            }
        }
        return dp[n-1];
    }
    public int min(int n1,int n2,int n3){
        return Math.min(n1,Math.min(n2,n3));
    }
}
