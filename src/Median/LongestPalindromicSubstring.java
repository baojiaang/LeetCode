package Median;
/*
* Solution: dynamic programing, use dp[][] to represent the status of subString i to j
* equation: dp[i][j] = dp[i+1][j-1] && s[i]==s[j] ,    i
* if s[i]==s[j] and j-i<3 , which means the length of subString is 1 or 2, in this case, this subString is palindromic
*
* initialize: in diagonal line, dp[i][i] = true
*
* return  the longest palindromicSubString, use a begin position and maxLen to get the subString
* */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2){
            return s;
        }

        int maxLen=1;
        int begin=0;


        // dp[i][j]  represent whether s is a palindromic string
        boolean dp[][]=new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }

        char charArray[]=s.toCharArray();
        // column first

        for(int j=1;j<len;j++){
            for(int i=0;i<len;i++){
                if(charArray[i]!=charArray[j]){  //this case, i,j position's chars are not same
                    dp[i][j]=false;
                }
                else{
                    if(j-i<3){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&& j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);

    }
}
