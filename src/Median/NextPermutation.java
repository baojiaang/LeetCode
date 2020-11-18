package Median;
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//        If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
//
//        The replacement must be in place and use only constant extra memory.
//
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/next-permutation
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

// 从后往前扫描，找到一个非降序的数字，然后从后往前到这个数的区间找一个比他大的，后面的数组反转
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
