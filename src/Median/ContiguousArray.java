package Median;

import java.util.HashMap;
/*
*Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contiguous-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 前缀和 + hashtable
* */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                sum += -1;
            }
            else{
                sum += 1;
            }
            if(map.containsKey(sum)) {
                int last = map.get(sum);
                max = Math.max(max,i - last);
            }
           else{
               map.put(sum,i);
            }
        }
        return max;
    }
}
