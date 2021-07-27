package Median;

import java.util.*;

public class Q1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        if(adjacentPairs.length == 1)
            return adjacentPairs[0];
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] adjacentPair: adjacentPairs){
            map.putIfAbsent(adjacentPair[0], new HashSet<Integer>());
            map.putIfAbsent(adjacentPair[1], new HashSet<Integer>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        int start = 0;
        for(Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() == 1){
                start = entry.getKey();
                break;
            }
        }
        res.add(start);
        int pre = start;
        int next = map.get(pre).iterator().next();
        while(map.get(next).size() > 1){
            res.add(next);
            map.get(next).remove(pre);
            pre  = next;
            next = map.get(pre).iterator().next();
        }
        res.add(next);
        int[] r = new int[res.size()];
        for(int i = 0; i < res.size();i++){
            r[i] = res.get(i);
        }
        return r;
    }
}
