package Median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4)
            return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i+1; j < nums.length-2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for(int m = j+1, n = nums.length-1; m < n ;){
                    int cur = nums[i] + nums[j] + nums[m] + nums[n];
                    if(cur == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        m++; n--;
                        while(m < n && nums[m] == nums[m-1] )
                            m++;
                        while(m < n && nums[n] == nums[n+1])
                            n--;
                    }
                    else if(cur < target){
                        m++;
                    }
                    else if(cur > target){
                        n--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum f = new FourSum();
        int[] nums = {2,2,2,2,2};
        System.out.println(f.fourSum(nums,8));
    }
}
