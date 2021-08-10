package Median;

public class Q581 {
    public int findUnsortedSubarray(int[] nums) {
        int left = -1, right = -1;
        int max_right = Integer.MIN_VALUE;
        int min_left = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(max_right > nums[i]){
                right = i;
            }
            else{
                max_right = nums[i];
            }
            if(min_left < nums[nums.length - i -1]){
                left = nums.length - i - 1;
            }
            else{
                min_left = nums[nums.length - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        Q581 q = new Q581();
        int[] nums = {1,2,3,4};
        System.out.println(q.findUnsortedSubarray(nums));
    }
}
