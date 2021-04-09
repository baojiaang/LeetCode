package Median;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 1; i<= n; i++){
            nums[i-1] = i;
        }
        back_track(nums,k,0,new ArrayList<Integer>());
        return res;
    }
    public void back_track(int[] nums, int k, int start,List<Integer> temp){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(!temp.contains(nums[i])) {
                temp.add(nums[i]);
            }
            back_track(nums,k,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}
