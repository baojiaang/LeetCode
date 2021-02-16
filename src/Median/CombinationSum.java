package Median;
/*
* Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
* 回溯法
*
* */
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(candidates,target,ans,temp,0);
        return ans;
    }
    public void dfs(int[] candidates, int target,List<List<Integer>> ans,List<Integer> temp,int index){
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        //不选择当前数
        dfs(candidates,target,ans,temp,index+1);
        //选择当前数
        if(target - candidates[index] >= 0){
            temp.add(candidates[index]);
            dfs(candidates,target-candidates[index],ans,temp,index);
            temp.remove(temp.size()-1);
        }
    }
}
