package weekend;

import java.util.HashMap;
import java.util.Map;

public class Q03 {
    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        int n = finalCnt.length + 1;
        int[][] matrix = new int[n][n];
        HashMap<Integer,Double> map = new HashMap<>();
        map.put(0,Double.valueOf(1));
        for(int i = 1; i <= n; i++){
            map.put(i,Double.valueOf(0));
        }
        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }
        double x = 0;
        for(int i = plans.length - 1; i >= 0; i--){
            int num = plans[i][0];
            int idx = plans[i][1];

            switch (num){
                case 1: {
                    if(idx == 0){
                        map.put(0,0.5 * map.get(0));
                    }
                    else{
                        finalCnt[idx-1] /= 2;
                    }
                    break;
                }
                case 2: {
                    int[] neibour = matrix[idx];
                    if(idx == 0){
                        for(int nei : neibour){
                            if(nei == 1)
                                map.put(nei,map.get(nei)+map.get(0));
                        }
                    }
                    else{
                        for(int nei : neibour){
                            if(nei == 1)
                                finalCnt[nei-1] += finalCnt[idx - 1];
                        }
                    }
                }
                case 3: {
                    int[] neibour = matrix[idx];
                    if(idx == 0){
                        for(int nei : neibour){
                            if(nei == 1)
                                map.put(nei,map.get(nei)-map.get(0));
                        }
                    }
                    else{
                        for(int nei : neibour){
                            if(nei == 1)
                                finalCnt[nei-1] -= finalCnt[idx - 1];
                        }
                    }
                }
            }
        }
        for(Map.Entry<Integer,Double> entry : map.entrySet()){
            x += entry.getValue();
        }
        int[] ret = new int[finalCnt.length + 1];
        for(int num : finalCnt){
            totalNum -= num;
        }
        int res = (int) (totalNum / x);
        ret[0] = res;
        for(int i = 1; i < ret.length; i++){
            ret[i] = finalCnt[i-1];
        }
        return ret;
    }
}
