package Median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        back_track(nums,0,new ArrayList<Integer>(),used);
        return res;
    }
    public void back_track(int[] nums, int start, List<Integer> temp,boolean[] used){
        res.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false)
                continue;
            temp.add(nums[i]);
            used[i] = true;
            back_track(nums,i+1,temp,used);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        SubsetsII s = new SubsetsII();
        int[] nums = {-1,1,2};
        s.subsetsWithDup(nums);
    }
}
