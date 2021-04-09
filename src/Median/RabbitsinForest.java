package Median;

import java.util.HashMap;
import java.util.Map;

public class RabbitsinForest {
    public int numRabbits(int[] answers) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < answers.length; i++){
            if(map.containsKey(answers[i])){
                int value = map.get(answers[i]);
                map.put(answers[i],value+1);
            }
            else{
                map.put(answers[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> e: map.entrySet()
             ) {
            int key = e.getKey();
            int value = e.getValue();
            while(value > 0){
                value -= (key+1);
                res += (key+1);
            }
        }
        return res;
    }
}
