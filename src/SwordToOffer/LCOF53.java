package SwordToOffer;

public class LCOF53 {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        int left = left_bound(nums,target);
        int right = right_bound(nums,target);
        if(left == -1 || right == -1)
            return 0;
        return right - left + 1;
    }
    public int left_bound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                right = mid - 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if( left  >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
    public int right_bound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if(right < 0 || nums[right] != target )
            return -1;
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        LCOF53 l = new LCOF53();
        System.out.println(l.search(nums,8));
    }
}
