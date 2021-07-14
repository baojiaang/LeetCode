package Median;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {
    public int countPairs(int[] deliciousness) {
        int[] two_powers = new int[22];
        for(int i = 0; i <= 21; i++){
            two_powers[i] = (int)Math.pow(2,i);
        }
        HashMap<Integer,Long> map = new HashMap<>();
        for(int n : deliciousness){
            map.put(n,map.getOrDefault(n,0l)+1);
        }
        long res = 0;
        ArrayList<Map.Entry<Integer,Long>> list = new ArrayList<>(map.entrySet());
        for(int i = 0; i < list.size(); i++){
            Map.Entry<Integer,Long> entry = list.get(i);
            int key = entry.getKey();
            long val = entry.getValue();
            for(int aim : two_powers){
                int need = aim - key;
                if(map.containsKey(need)){
                    long val_2 = map.get(need);
                    if(need == key){
                        res += (val * (val - 1) / 2) % 1000000007;
                    }
                    else{
                        res += (val * val_2) % 1000000007;
                    }
                }
            }
            map.remove(key);
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int[] nums = {1048576,1048576};
        CountGoodMeals c = new CountGoodMeals();
        System.out.println(c.countPairs(nums));
    }
}
