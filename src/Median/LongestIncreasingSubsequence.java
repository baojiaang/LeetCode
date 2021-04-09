package Median;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j >= 0; j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < dp.length; i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
