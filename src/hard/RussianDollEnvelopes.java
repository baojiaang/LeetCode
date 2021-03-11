package hard;

import java.util.Arrays;
import java.util.Comparator;
/*
* You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/russian-doll-envelopes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
* 套娃问题  先对宽度进行排序
*同一宽度，长度长的在前面，因为同一宽度只能用一个信封，这样就保证长度的递增
* 转换成最长递增子序列问题
* */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        int res = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        for(int i = 1; i < envelopes.length; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
