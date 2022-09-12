package Easy;

public class Q1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ret = new int[2*n];
        int idx = -1;
        for(int i = 0; i < n; i++){
            ret[++idx] = nums[i];
            ret[++idx] = nums[n+i];
        }
        return ret;
    }

}
