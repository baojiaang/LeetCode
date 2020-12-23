package Easy;

import java.util.HashMap;

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else{
                int num = map.get(c);
                map.put(c,num+1);
            }
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int num = map.get(c);
            if(num==1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        FirstUniqueCharacterinaString f = new FirstUniqueCharacterinaString();
        f.firstUniqChar(s);
    }
}
