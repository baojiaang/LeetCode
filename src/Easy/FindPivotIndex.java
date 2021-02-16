package Easy;
/*
* Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-pivot-index
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 先判断，再加
* 先算出总的和，
* 移动index
* 左边和==？总的和-左边和-pivot（右边）
* 返回index
* */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int i:nums) {
            total+=i;
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(total-sum-nums[i]==sum)
                return i;
            sum+=nums[i];
        }
        return -1;
    }
}
