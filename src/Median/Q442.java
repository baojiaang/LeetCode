package Median;

import java.util.ArrayList;
import java.util.List;

public class Q442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != nums[nums[i] - 1]){
                swap(i,nums[i] - 1, nums);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                ret.add(nums[i]);
            }
        }
        return ret;
    }

    public void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Q442 q = new Q442();
        int[] nums = {5,4,6,7,9,3,10,9,5,6};
        System.out.println(q.findDuplicates(nums));
    }
}
