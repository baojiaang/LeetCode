package Easy;

import java.util.HashMap;
import java.util.HashSet;
/*
* Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumberofEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int length = dominoes.length;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            int large = a>b?a:b;
            int small = a>b?b:a;
            String s = ""+large+small;
            if(map.containsKey(s)){
                int count = map.get(s);
                count++;
                map.put(s,count);
            }
            else{
                map.put(s,0);
            }
        }
        int res = 0;
        for (String key:map.keySet()
             ) {
            int count = map.get(key);
            for(int j=count;j>0;j--){
                res += j;
            }
        }
        return res;
    }
}
