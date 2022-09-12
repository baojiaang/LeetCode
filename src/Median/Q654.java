package Median;

import java.util.Arrays;
import java.util.HashMap;

public class Q654 {
    HashMap<Integer,Integer> map = new HashMap();
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        TreeNode root = construct(nums,0, nums.length - 1);
        return root;
    }
    public TreeNode construct(int[] nums, int left, int right){
        if(left < 0 || right >= nums.length || left > right){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int i = left;
        for(; i <= right; i++){
            max = Math.max(nums[i], max);
        }
        TreeNode root = new TreeNode(max);
        System.out.println(max);
        root.left = construct(nums, left, map.get(max) - 1);
        root.right = construct(nums,map.get(max) + 1,right);
        return root;
    }
}
