package Median;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        back_track(nums,new ArrayList<Integer>(),new HashSet<Integer>());
        return res;
    }
    public void back_track(int[] nums, List<Integer> temp, HashSet<Integer> set){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
        }
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            set.add(nums[i]);
            back_track(nums,temp,set);
            temp.remove(temp.size()-1);
            set.remove(nums[i]);
        }
    }
}
