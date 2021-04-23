package hard;

public class ScrambleString {
    public boolean isScramble(String s, String t){
        // base case  when two strings' length are not same
        if(s.length() != t.length())
            return false;

        int n = s.length();

        //第一个 n  从 i开始的，长度为k的s子字符串   第二个n 从j开始的长度为k的子字符串   第三个n 长度k
        boolean dp[][][] = new boolean[n][n][n+1];

        // base case 判断长度为1时是否字符相等
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n; j++){
                if(s.charAt(i) == t.charAt(j))
                    dp[i][j][1] = true;
                else
                    dp[i][j][1] = false;
            }
        }


        //比较翻转和不翻转的情况
        for(int k = 2; k <= n; k++){
            for(int i = 0; (i+k) <= n; i++){
                for(int j = 0; (j+k) <= n; j++){
                    for(int ck = 1; ck < k; ck++){
                        dp[i][j][k] |= (dp[i][j][ck] && dp[i+ck][j+ck][k-ck] || dp[i][j+k-ck][ck] && dp[i+ck][j][k-ck]);
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
