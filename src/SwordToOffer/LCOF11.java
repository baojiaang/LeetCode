package SwordToOffer;
/*
*  旋转过后找最小值，有重复数字
*  如果nums【mid】 == nums【high】  最后一条线可能水平 high-- 往前走
*
* */
public class LCOF11 {
    public int minArray(int[] numbers) {
        return binary_search(numbers,0,numbers.length - 1);
    }
    public int binary_search(int[] nums,int left, int right){
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else if(nums[mid] < nums[right]){
                right = mid;
            }
            else{
                right--;
            }
        }
        return nums[left];
    }
}
