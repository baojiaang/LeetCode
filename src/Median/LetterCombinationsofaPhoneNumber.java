package Median;
/*
* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 回溯法
* */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits.length()==0){
            return combinations;
        }
        Map<Character,String> phoneMap = new HashMap<Character, String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }
        };
        backtrace(combinations,phoneMap,digits,0,new StringBuffer());
        return combinations;
    }
    public void backtrace(List<String> combinations, Map<Character,String> phoneMap,String digits,int index, StringBuffer combination){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }
        else{
            char digit = digits.charAt(index);
            String letters= phoneMap.get(digit);
            for(int i=0; i<letters.length();i++){ // 回溯
                combination.append(letters.charAt(i)); // 先加
                backtrace(combinations,phoneMap,digits,index+1,combination); // 递归
                combination.deleteCharAt(index); // 进行回溯，删除之前加上的
            }
        }
    }
}
