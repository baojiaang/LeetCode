package Median;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
//        int right_bound = right_bound(matrix,target);

        for(int i = 0;i < matrix.length; i++){
            int res = binary_search(matrix[i],target);
            if(res != -1){
                return true;
            }
        }
        return false;
    }
    public int binary_search(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }
    public int left_bound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        if(left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
    public int right_bound(int[][] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid][0] == target){
                left = mid + 1;
            }
            else if(nums[mid][0] < target){
                left = mid + 1;
            }
            else if(nums[mid][0] > target){
                right = mid - 1;
            }
        }
        if(right < 0 || nums[right][0] != target)
            return -1;
        return right;
    }
}
