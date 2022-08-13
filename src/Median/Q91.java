package Median;

public class Q91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        if(s.charAt(0) == '0'){
            return 0;
        }
        dp[0] = 1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '0'){
                dp[i+1] += dp[i];
                if(i - 1 >= 0 && s.charAt(i-1) != '0' && ((s.charAt(i-1) - '0') * 10 + s.charAt(i) - '0') <= 26){
                    dp[i+1] += dp[i-1];
                }
            }
            else{
                if(i - 1 >= 0 && s.charAt(i-1) != '0' && ((s.charAt(i-1) - '0') * 10 + s.charAt(i) - '0') <= 26){
                    dp[i+1] += dp[i-1];
                }
            }
        }
        return dp[s.length()];
    }
}
