package Easy;

public class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if(i < 0 || j >= nums.length)
            return 0;
        if(i == j)
            return nums[i];
        int result = 0;
        for(int start = i; start <= j; start++){
            result += nums[start];
        }
        return result;
    }
}
