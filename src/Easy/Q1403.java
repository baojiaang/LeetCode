package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int cur = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            ret.add(nums[i]);
            cur += nums[i];
            sum -= nums[i];
            if(cur > sum){
                return ret;
            }
        }
        return ret;
    }
}
