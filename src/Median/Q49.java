package Median;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] count = strCount(str);
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < count.length; i++){
                sb.append((char)('a' + i));
                sb.append(count[i]);
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            ret.add(entry.getValue());
        }
        return ret;
    }
    public int[] strCount(String str){
        int[] ret = new int[26];
        for(char c : str.toCharArray()){
            ret[c - 'a']++;
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Q49 q = new Q49();
        System.out.println(q.groupAnagrams(strs));
    }
}
