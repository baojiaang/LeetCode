package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Q1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<One> list = new ArrayList<>();
        for(int i = 0; i < mat.length; i++){
            int sum = IntStream.of(mat[i]).sum();
            One one = new One(i,sum);
            list.add(one);
        }
        list.sort((One o1, One o2) -> o1.num == o2.num ? o1.row - o2.row : o1.num - o2.num);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = list.get(i).row;
        }
        return res;
    }
}
class One{
    int row;
    int num;
    One(int row, int num){
        this.row = row;
        this.num = num;
    }
}