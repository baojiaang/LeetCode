package Easy;

import java.util.ArrayList;
import java.util.List;
/*
* 算出各个点的距离，利用桶排序
*We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.

Additionally, we are given a cell in that matrix with coordinates (r0, c0).

Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0,R-1-r0) + Math.max(c0,C-1-c0);
        List<List<int[]>> bucket = new ArrayList<>();
        for(int i=0;i<= maxDist; i++){
            bucket.add(new ArrayList<int[]>());
        }
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                int d = dist(i,j,r0,c0);
                bucket.get(d).add(new int[]{i,j});
            }
        }
        int [][] ret = new int[R*C][];
        int index = 0;
        for(int i=0; i<=maxDist; i++){
            for(int[] it:bucket.get(i)){
                ret[index++] = it;
            }
        }
        return ret;
    }
    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

}
