package hard;
/*
* Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
* 动态规划   
*
* */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioningII {
    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    boolean[][] dp;
    public int minCut(String s) {
        int n = s.length();
        dp = new boolean[n][n];

        for(int i= 0; i < n; i++){
            Arrays.fill(dp[i],true);
        }

        // 动态规划预处理 判断 i到j位置是否为回文串

        for(int i = n-1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }

}
