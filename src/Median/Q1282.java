package Median;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ret = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++){
            int num = groupSizes[i];
            List<Integer> numList = map.getOrDefault(num, new ArrayList<Integer>());
            numList.add(i);
            map.put(num, numList);
        }
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            int num = entry.getKey();
            List<Integer> numList = entry.getValue();
            for(int i = 0;i < numList.size();) {
                List<Integer> temp = new ArrayList<>();
                for (int count = 0; count < num; count++) {
                    temp.add(numList.get(i));
                    i++;
                }
                ret.add(temp);
            }
        }
        return ret;
    }
}
        