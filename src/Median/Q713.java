package Median;

public class Q713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ret = 0;
        int left = 0, right = 0;
        int base = 1;
        for(; right < nums.length; right++){
            base *= nums[right];
            while(left <= right && base >= k){
                base /= nums[left];
                left++;
            }
            ret += (right - left + 1);
        }
        return ret;
    }
}
