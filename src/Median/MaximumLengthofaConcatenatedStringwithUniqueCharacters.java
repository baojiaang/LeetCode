package Median;

import java.util.*;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    public int maxLength(List<String> arr) {
        List<HashSet<Character>> all = new ArrayList<>();
        all.add(new HashSet<>());
        int ans = 0;
        for(String str : arr){
            int strs = all.size();
            for(int i = 0; i < strs; i++){
                HashSet<Character> s = all.get(i);
                HashSet<Character> tmp = new HashSet<>(all.get(i));
                int len = str.length();
                for(int k = 0; k < len; k++){
                    tmp.add(str.charAt(k));
                }
                if(tmp.size() == s.size() + len){
                    all.add(tmp);
                    ans = Math.max(ans, tmp.size());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumLengthofaConcatenatedStringwithUniqueCharacters m = new MaximumLengthofaConcatenatedStringwithUniqueCharacters();
        List<String> arr = new ArrayList<>();
        arr.add("a"); arr.add("abc"); arr.add("d"); arr.add("de"); arr.add("def");
        System.out.println(m.maxLength(arr));
    }
}
