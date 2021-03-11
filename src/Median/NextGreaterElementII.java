package Median;
/*
* Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-greater-element-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 循环数组找最近的最大值
*
* 单调栈
* 取模来实现循环取值
* */
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        Stack<Integer> greaterStack = new Stack<>();   // 单调栈,栈中存放的是比当前nums[i]中大的数的索引
        for(int i = 0; i < 2 * nums.length-1; i++){
            while(!greaterStack.empty() && nums[greaterStack.peek()] < nums[i % nums.length]){
                res[greaterStack.pop()] = nums[i % nums.length];
            }
            greaterStack.push(i%nums.length); // 存 index
        }
        return res;
    }
}
