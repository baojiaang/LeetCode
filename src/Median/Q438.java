package Median;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Integer,HashMap<Character,Integer>> map = new HashMap<>();
        HashMap<Character,Integer> pMap = new HashMap<>();
        for(char c : p.toCharArray()){
            pMap.put(c, pMap.getOrDefault(c,0) + 1);
        }
        List<Integer> ret = new ArrayList<>();
        if(s.length() < p.length()){
            return ret;
        }
        HashMap<Character,Integer> sMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c,0) + 1);
        }
        map.put(0,sMap);
        if(sMap.equals(pMap)){
            ret.add(0);
        }
        int pre = 0;
        for(int i = p.length(); i < s.length(); i++){
            sMap = map.get(pre);
            sMap.put(s.charAt(pre),sMap.get(s.charAt(pre)) - 1);
            if(sMap.get(s.charAt(pre)) == 0){
                sMap.remove(s.charAt(pre));
            }
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0) + 1);
            pre++;
            map.put(pre,sMap);
            if(sMap.equals(pMap)){
                ret.add(pre);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Q438 q = new Q438();
        String s = "abab";
        String p = "a";

        System.out.println(q.findAnagrams(s,p));

    }

}
