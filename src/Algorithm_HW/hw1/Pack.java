package Algorithm_HW.hw1;

import java.util.*;

public class Pack {

    /*
    *   W represents the space of pack
    *   N represents the number of items
    * */
    public int knapsack(int N, int W, int[] weights, int[] values) {
        int dp[][] = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {  //是否能放进
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
				    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }
    /*
    * fill up all space
    * need change the initial state
    * */
    public int knapsackWithFillUp(int N, int W, int[] weights, int[] values){
        int dp[][] = new int[N+1][W+1];
        for (int i=1;i<=N;i++)
            for(int j=1;j<=N;j++)
                dp[i][j] = Integer.MIN_VALUE;
        for (int i=1; i<=N; i++){
            dp[i][0] = 0;
            int w = weights[i-1], v = values[i-1];
            for (int j = 1; j <= W; j++){
                if(j >= w){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w]+v);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }
    /*
    *  i : i th item       1-N
    *  j : size of first pack  1-W1
    *  k : size of second pack 1-W2
    * */
    public int twoPack(int N, int W1,int W2, int[] weights, int[] values){
        int dp[][][] = new int[N+1][W1+1][W2+1];
        for(int i=1;i<=N;i++){
            int w = weights[i - 1], v = values[i - 1];
            for(int j=1;j<=W1;j++){
                for(int k=1;k<=W2;k++){
                    if(j>=w&&k<w){
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-w][k]+v);
                    }
                    if(j>=w&&k>=w){
                        dp[i][j][k] = Math.max(dp[i-1][j][k],Math.max(dp[i-1][j-w][k]+v,dp[i-1][j][k-w]+v));
                    }
                    if(j<w&&k>=w){
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j][k-w]+v);
                    }
                    else{
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[N][W1][W2];
    }

    /*
    *  add extra dimension to record k max item that can pick
    * */
    public int Mitems(int N, int W, int[] weights,int[] values, int M){
        int dp[][][] = new int[M+1][N+1][W+1];
        for (int i=1;i<=N;i++){
            int w = weights[i - 1], v = values[i - 1];
            for (int j=1;j<=W;j++){
                for(int k=1;k<=M;k++){
                    if(j>w){
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-w][k-1]+v);
                    }
                    else{
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[N][W][M];
    }

    public static void main(String[] args) {

    }
}
