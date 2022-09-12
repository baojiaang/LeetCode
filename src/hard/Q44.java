package hard;

public class Q44 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i <= p.length(); i++){
            if(p.charAt(i-1) == '*' ){
                dp[i][0] = true;
            }
        }
        for(int i = 1; i <= p.length(); i++){
            for(int j = 1; j <= s.length(); j++){
                if(Character.isLetter(p.charAt(i-1))){
                    if(s.charAt(j-1) == p.charAt(i-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else if(p.charAt(i-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    public static void main(String[] args) {
        Q44 q = new Q44();
        System.out.println(q.isMatch("de","de*"));
    }
}
