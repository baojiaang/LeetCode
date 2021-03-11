package Median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {

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

        dfs(s,0);
        return res;
    }

    // 回溯
    public void dfs(String s, int start){
        if(start == s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int j = start; j < s.length(); j++){
            if(dp[start][j]){
                ans.add(s.substring(start,j+1));
                dfs(s,j+1); // 从下一个位置切分 进行dfs
                ans.remove(ans.size() - 1);
            }
        }
    }
}
