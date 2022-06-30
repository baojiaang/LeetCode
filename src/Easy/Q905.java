package Easy;

public class Q905 {
    public int[] sortArrayByParity(int[] nums) {
        int lIdx = 0, rIdx = nums.length - 1;
        while(lIdx < rIdx){
            while (lIdx < nums.length && lIdx < rIdx && nums[lIdx] % 2 == 0){
                lIdx++;
            }
            while(rIdx >= 0 && lIdx < rIdx && nums[rIdx] % 2 == 1){
                rIdx--;
            }
            if(lIdx < rIdx){
                swap(lIdx, rIdx, nums);
                lIdx++;
                rIdx--;
            }
        }
        return nums;
    }
    public void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
