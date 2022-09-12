package Median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates,target,0,new ArrayList<>(),0);
        return ret;
    }

    public void backTrack(int[] candidates, int target, int idx,List<Integer> temp, int sum){
        if(sum > target){
            return;
        }
       if(sum == target){
            ret.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i < candidates.length; i++) {
            if(i > idx && candidates[i-1] == candidates[i]){
                continue;
            }
            temp.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, i+1, temp,sum);
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }

    }
}
