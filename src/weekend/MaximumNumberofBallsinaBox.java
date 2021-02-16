package weekend;

import java.util.HashMap;

public class MaximumNumberofBallsinaBox {
        public int countBalls(int lowLimit, int highLimit) {
            HashMap<Integer,Integer> result = new HashMap<>();
            for(int i=lowLimit;i<=highLimit;i++){
                int temp = i;
                int key = 0;
                while(temp>0){
                    int a = temp%10;
                    key += a;
                    temp /= 10;
                }
                if(result.containsKey(key)){
                    int pre = result.get(key);
                    pre++;
                    result.put(key,pre);
                }
                else{
                    result.put(key,1);
                }
            }
            int res = 0;
            for (Integer key:result.keySet()
                 ) {
                int times = result.get(key);
                if(times>res)
                    res = times;
            }
            return res;
        }
}
