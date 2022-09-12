package Median;

import java.util.Arrays;

public class Q45 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; i + j + 1 < nums.length && j < nums[i]; j++){
                dp[i + j + 1] = Math.min(dp[i + j + 1],dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}
