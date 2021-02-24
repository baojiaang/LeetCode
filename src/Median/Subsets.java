package Median;
/*
* Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 位运算
*
* */
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int maskLength = 1 << nums.length;
        for(int mask = 0; mask < maskLength; mask++){
            temp.clear();
            for(int i = 0; i < nums.length; i++){
                if((mask & (1 << i)) != 0){
                    temp.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
    public static void main(String[] args) {
        int i = 1;
        System.out.println(i<<2);
    }
}
