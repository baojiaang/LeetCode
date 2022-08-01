package Easy;

import java.util.*;

public class Q1331 {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        for(int i = 0; i < arr.length; i++){
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        int idx = 1;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            for(int num : list){
                arr[num] = idx;
            }
            idx++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Q1331 q = new Q1331();
        int[] arr= {40,10,20,30};
        System.out.println(q.arrayRankTransform(arr));
    }
}
