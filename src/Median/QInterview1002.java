package Median;

import java.util.*;

public class QInterview1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] char_arr = s.toCharArray();
            Arrays.sort(char_arr);
            String modify_s = new String(char_arr);
            if(map.containsKey(modify_s)){
                List<String> list = map.get(modify_s);
                list.add(s);
                map.put(modify_s,list);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(modify_s,list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs= new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        QInterview1002 q = new QInterview1002();
        System.out.println(q.groupAnagrams(strs));
    }
}
