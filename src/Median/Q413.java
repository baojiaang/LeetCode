package Median;

public class Q413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] diff = new int[nums.length];
        if(nums.length < 3){
            return 0;
        }
        for(int i = 1; i < nums.length; i++){
            diff[i] = nums[i] - nums[i-1];
        }
        diff[0] = Integer.MIN_VALUE;
        int cur = diff[0];
        int res = 0;
        int cur_len = 0;
        for(int i = 1; i < diff.length; i++){
            if(diff[i] == cur){
                cur_len++;
                if(cur_len == 2 && diff[i-2] != diff[i]){
                    cur_len = 3;
                }
            }
            else if(diff[i] != cur){
                if(cur_len >= 3){
                    for(int j = cur_len; j >= 3; j--){
                        res += c(j,cur_len);
                    }
                }
                cur_len = 1;
            }
            cur = diff[i];
        }
        if(cur_len >= 3){
            for(int j = cur_len; j >= 3; j--){
                res += c(j,cur_len);
            }
        }
        return res;
    }
    public int c(int m, int n){
        return n - m + 1;
    }

    public static void main(String[] args) {
        Q413 q = new Q413();
        int[] nums = {1,1,1,1,1,1,1,1,1};
        System.out.println(q.numberOfArithmeticSlices(nums));
    }
}
