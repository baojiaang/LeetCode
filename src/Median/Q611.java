package Median;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q611 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                while( k + 1 < n && nums[k+1] < nums[i] + nums[j]){
                    k++;
                }
                res += Math.max(k-j,0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q611 q = new Q611();
        int[] nums = {2,2,3,4};
        System.out.println(q.triangleNumber(nums));
    }
}
