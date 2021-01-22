package hard;
/*
* There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/candy
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 思路：左规则，从左往右扫，rating大时左边=右边+1，否则1 有规则，从右往左扫，增加的规则类似
* 我的思路：只想到了左规则，右边扫了好多次，慢
* */
public class Candy {
    public int candy(int[] ratings) {
        int count = 0;
        int[] candys = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candys[i] = 1;
            if (i > 0) {
                for(int j=i;j>0;j--){
                    if(ratings[j-1]>ratings[j]){
                        if(candys[j-1]<=candys[j]){
                            candys[j-1]++;
                        }
                    }
                    else{
                        break;
                    }
                }
                if (ratings[i - 1] < ratings[i]) {
                    candys[i] = candys[i - 1] + 1;
                }
            }
        }
        for (int i = 0; i < candys.length; i++) {
            count += candys[i];
        }
        return count;
    }
}
