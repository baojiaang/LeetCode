package Median;
/*
* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrace(res,new StringBuffer(),n,n);
        return res;
    }
    public void backTrace(List<String> result, StringBuffer tempString, int right, int left){
        if(right == 0 && left == 0){
            result.add(tempString.toString());
            return;
        }
        if(right > 0){
            tempString.append("(");
            backTrace(result,tempString,right-1,left);
            tempString.deleteCharAt(tempString.length()-1);
        }
        if(right < left){
            tempString.append(")");
            backTrace(result,tempString,right,left-1);
            tempString.deleteCharAt(tempString.length()-1);
        }
    }
}
