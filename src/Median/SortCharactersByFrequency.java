package Median;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(Map.Entry<Character,Integer> e1, Map.Entry<Character,Integer> e2) -> e2.getValue() - e1.getValue());
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> e : list){
            for(int i = 0; i < e.getValue(); i++){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
