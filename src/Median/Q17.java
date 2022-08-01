package Median;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q17 {
    HashMap<Integer,char[]> map = new HashMap<>();
    List<String> ret;
    public List<String> letterCombinations(String digits) {
        char[] words = new char[]{'a','b','c'};
        ret = new ArrayList<>();
        if(digits.length() == 0){
            return ret;
        }
        map.put(2,words);
        words = new char[]{'d', 'e', 'f'};
        map.put(3,words);
        words = new char[]{'g','h','i'};
        map.put(4,words);
        words = new char[]{'j','k','l'};
        map.put(5,words);
        words = new char[]{'m','n','o'};
        map.put(6,words);
        words = new char[]{'p','q','r','s'};
        map.put(7, words);
        words = new char[]{'t','u','v'};
        map.put(8,words);
        words = new char[]{'w','x','y','z'};
        map.put(9,words);
        backTrack(digits,0, new StringBuilder());
        return ret;
    }

    public void backTrack(String digits, int index, StringBuilder sb){
        if(index == digits.length()){
            ret.add(sb.toString());
        }
        else{
            char digit = digits.charAt(index);
            char[] words = map.get(digit - '0');
            for(int i = 0; i < words.length; i++){
                sb.append(words[i]);
                backTrack(digits,index+1,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String test = "23";
        Q17 q = new Q17();
        System.out.println(q.letterCombinations(test));
    }
}
