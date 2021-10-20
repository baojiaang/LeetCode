package Median;

public class Q516 {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String re_s = sb.reverse().toString();
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= s.length(); j++){
                if(s.charAt(i-1) == re_s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][s.length()];
    }

    public static void main(String[] args) {
        Q516 q = new Q516();
        String s = "cbbd";
        System.out.println(q.longestPalindromeSubseq(s));
    }
}
