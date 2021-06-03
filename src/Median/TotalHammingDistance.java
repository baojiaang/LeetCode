package Median;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        for(int i = 0; i < 30; i++){
            int c = 0;
            for(int j = 0; j < nums.length; j++){
                c += (nums[j] >> i) & 1;
            }
            res += c * (n-c);
        }
        return res;
    }
}
