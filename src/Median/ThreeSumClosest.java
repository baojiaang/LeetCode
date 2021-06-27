package Median;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int abs = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - 3; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < nums.length && right >= 0 &&left < right ){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum-target) < abs){
                    res = sum;
                    abs = Math.abs(sum - target);
                }
                if(sum > target){
                    right--;
                }
                else if(sum < target){
                    left++;
                }
                else{
                    return sum;
                }

            }
        }
        return res;
    }
}
