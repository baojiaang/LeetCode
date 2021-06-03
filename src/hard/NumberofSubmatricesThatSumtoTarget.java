package hard;

import java.util.HashMap;
import java.util.Map;

public class NumberofSubmatricesThatSumtoTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        for(int i = 0; i < matrix.length; i++){
            int[] sum = new int[matrix[0].length];
            for(int j = i; j < matrix.length; j++){
                for(int k = 0; k < matrix[0].length; k++){
                    sum[k] += matrix[j][k];
                }
                res += subArrayFindTarget(sum,target);
            }
        }
        return res;
    }
    public int subArrayFindTarget(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0, pre = 0;
        for(int num : nums){
            pre += num;
            if(map.containsKey(pre - target)){
                count += map.get(pre - target);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
