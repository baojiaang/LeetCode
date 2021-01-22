package hard;
/*
* Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 思路： curEnd记录当前步最远能走的距离
* bound记录当前步中最远能到的边界
* 扫描数组，i为当前位置，如果i碰到curEnd时，steps++
* */
public class JumpGame2 {
    public int jump(int[] nums) {
        int bound=0;
        int curEnd=0;
        int steps=0;
        for(int i=0;i<nums.length-1;i++){
            bound = Math.max(bound,i+nums[i]);
            if(i==curEnd){
                curEnd=bound;
                steps++;
            }
        }
        return steps;
    }
}
