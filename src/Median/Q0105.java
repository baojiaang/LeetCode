package Median;

public class Q0105 {
    public boolean oneEditAway(String first, String second) {
//        int[][] dp = new int[first.length() + 1][second.length() + 1];
//        for(int i = 1; i < dp.length; i++){
//            dp[i][0] = i;
//        }
//        for(int i = 1; i < dp[0].length; i++){
//            dp[0][i] = i;
//        }
//        for(int i = 1; i < dp.length; i++){
//            for(int j = 1; j < dp[0].length; j++){
//                if(first.charAt(i - 1) == second.charAt(j - 1)){
//                    dp[i][j] = dp[i - 1][j - 1];
//                }
//                else{
//                    dp[i][j] = Math.min(dp[i][j - 1],Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
//                }
//            }
//        }
//        return dp[first.length()][second.length()] <= 1;
        int a = first.length(), b = second.length();
        if(Math.abs(a - b) > 1){
            return false;
        }
        if(a > b){
            return oneEditAway(second, first);
        }
        int i = 0, j = 0, cnt = 0;
        while(i < a && j < b && cnt <= 1){
            char c1 = first.charAt(i);
            char c2 = second.charAt(j);
            if(c1 == c2){
                i++;
                j++;
            }
            else{
                if(a == b){
                    i++;j++;cnt++;
                }
                else{
                    j++;cnt++;
                }
            }
        }
        return cnt <= 1;
    }
}
