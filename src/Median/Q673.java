package Median;

import java.util.Arrays;

public class Q673 {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] times = new int[nums.length];
        dp[0] = 1;
        Arrays.fill(times,1);
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]){
                   if(dp[j] + 1 > dp[i]){
                       times[i] = times[j];
                       dp[i] = dp[j] + 1;
                   }
                   else if(dp[j] + 1 == dp[i]){
                       times[i] += times[j];
                   }
                }
            }
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(dp[i] > max){
                res = times[i];
                max = dp[i];
            }
            else if(dp[i] == max){
                res += times[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q673 q = new Q673();
        int[] nums = {1,3,5,4,7};
        System.out.println(q.findNumberOfLIS(nums));
    }
}
