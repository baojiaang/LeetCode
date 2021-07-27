package Median;

import java.util.Arrays;

public class Q1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        int res = Integer.MIN_VALUE;
        while(l < r){
            res = Math.max(res,nums[l] + nums[r]);
            l++;
            r--;
        }
        return res;
    }
}
