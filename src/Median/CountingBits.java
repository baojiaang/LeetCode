package Median;
/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 二进制统计1的个数
 *
 * 思路：若为n奇数，则等于 n/2 时的个数 +1
 * n为偶数，则为n/2的个数 因为 n/2 左移以为为 n 1的个数不变
 * */
public class CountingBits {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for(int i = 0; i <= num; i++){
            if(i%2 == 0)
                dp[i] = dp[i/2];
            else
                dp[i] = dp[i/2] + 1;
        }
        return dp;
    }
}
