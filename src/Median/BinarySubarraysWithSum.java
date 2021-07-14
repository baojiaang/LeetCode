package Median;

import java.util.HashMap;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int pre = 0;
        for(int i = 0; i < nums.length; i++){
            pre += nums[i];
            if(map.containsKey(pre - goal))
                res += map.get(pre - goal);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum b = new BinarySubarraysWithSum();
        int[] nums = {1,0,1,0,1};
        System.out.println(b.numSubarraysWithSum(nums,2));
    }
}
