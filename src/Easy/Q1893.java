package Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class Q1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] bucket = new int[right-left+1];
        for(int i = 0; i < ranges.length; i++){
            int l = ranges[i][0];
            int r = ranges[i][1];
            int len = right - left;
            if(l - left > len || r - left < 0){
                continue;
            }
            int l_idx = l - left < 0 ? 0 : l - left;
            int r_idx = r - left > len ? len : r - left;
            Arrays.fill(bucket,l_idx,r_idx+1,1);
        }
        for(int n : bucket){
            if(n != 1)
                return false;
        }
        return true;
    }

}
