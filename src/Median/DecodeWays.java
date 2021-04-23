package Median;
/*
*
* A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        char[] nums = s.toCharArray();
        if(nums[0] == '0')
            return 0;
        int[] dp = new int[n+1];

        dp[0] = 1;     //空字符串 不用任何编码 所以有一种解法

        for(int i = 1; i <= n; i++){
            if(nums[i-1] != '0'){
                // 单独取
                dp[i] += dp[i-1];

                // 取两个连起来

                if(i-2 >= 0){
                    if(nums[i-2] != '0' && ((nums[i-2] - '0') * 10 + nums[i-1] - '0') <= 26 )
                        dp[i] += dp[i-2];
                }
            }
            else{
                // 取两个连起来
                if(i-2 >= 0){
                    if(nums[i-2] != '0' && ((nums[i-2] - '0') * 10 + nums[i-1] - '0') <= 26 )
                        dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }
}
