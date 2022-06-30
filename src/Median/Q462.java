package Median;

import java.util.Arrays;

public class Q462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = (nums.length - 1) / 2;
        int ret = 0;
        for(int n : nums){
            ret += Math.abs(n - nums[mid]);
        }
        return ret;
    }
}
