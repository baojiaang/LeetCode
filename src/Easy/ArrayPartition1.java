package Easy;
/*
* Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/array-partition-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 排序
* */
import java.util.Arrays;

public class ArrayPartition1 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i=0;i<nums.length;i+=2){
           int num = Math.min(nums[i],nums[i+1]);
           result += num;
        }
        return result;
    }
}
