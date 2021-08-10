package Median;

import java.util.HashMap;
import java.util.HashSet;

public class Q457 {
    boolean[] can_not;
    boolean flag = false;
    public boolean circularArrayLoop(int[] nums) {
        can_not = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(can_not[i] == false){
                HashSet<Integer> is_visited = new HashSet<>();
                dfs(nums,i,nums[i],is_visited);
                if(flag == true && is_visited.size() > 1)
                    return true;
            }
        }
        return false;
    }
    public void dfs(int[] nums, int cur_idx, int pre, HashSet<Integer> is_visited){
        if(is_visited.contains(cur_idx)){
            flag = true;
            return;
        }
        if(cur_idx >= 0 && ((pre > 0 && nums[cur_idx] > 0) || (pre < 0 && nums[cur_idx] < 0))){
            is_visited.add(cur_idx);
            int next_idx = (cur_idx + nums[cur_idx]) % nums.length;
            if(next_idx < 0){
                next_idx = nums.length + next_idx;
            }
            if(next_idx == cur_idx){
                for(Integer idx : is_visited){
                    can_not[idx] = true;
                }
                if(cur_idx >= 0 && nums[cur_idx] == 0)
                    can_not[cur_idx] = true;
                flag = false;
                return;
            }
            dfs(nums,next_idx,nums[cur_idx],is_visited);
        }
        else{
            for(Integer idx : is_visited){
                can_not[idx] = true;
            }
            if(cur_idx >= 0 && nums[cur_idx] == 0)
                can_not[cur_idx] = true;
            flag = false;
            return;
        }
    }

    public static void main(String[] args) {
        Q457 q = new Q457();
        int[] nums = {-1,-1,-1};
        System.out.println(q.circularArrayLoop(nums));
    }
}
