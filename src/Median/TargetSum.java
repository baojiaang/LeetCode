package Median;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        HashMap<Integer,Integer> f1 = new HashMap<>();
        f1.put(nums[0],1);
        f1.put(-nums[0],1 + f1.getOrDefault(-nums[0],0));
        map.put(0,f1);
        for(int i = 1; i < nums.length; i++){
            HashMap<Integer,Integer> pre = map.get(i-1);
            HashMap<Integer,Integer> cur = new HashMap<>();

            for (Map.Entry<Integer,Integer> entry: pre.entrySet()
                 ) {
                int key = entry.getKey();
                int val = entry.getValue();
                cur.put(key+nums[i],val + cur.getOrDefault(key + nums[i],0));
                cur.put(key-nums[i],val + cur.getOrDefault( key - nums[i],0));
            }
            map.put(i,cur);
        }
        HashMap<Integer,Integer> res_map = map.get(nums.length - 1);
        return res_map.getOrDefault(target,0);
    }

    public static void main(String[] args) {
        int[] nums = { 0,0,0,0,0,0,0,0,1};
        TargetSum t = new TargetSum();
        System.out.println(t.findTargetSumWays(nums,1));
    }
}
