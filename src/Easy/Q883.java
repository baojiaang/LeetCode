package Easy;

public class Q883 {
    public int projectionArea(int[][] grid) {
        int ret = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] != 0){
                    ret++;
                }
            }
        }
        for(int j = 0; j < grid[0].length; j++){
            int i_max = Integer.MIN_VALUE;
            for(int i = 0; i < grid.length; i++){
                i_max = Math.max(i_max,grid[i][j]);
            }
            ret += i_max;
        }
        for(int i = 0; i < grid.length; i++){
            int j_max = Integer.MIN_VALUE;
            for(int j = 0; j < grid[0].length; j++){
                j_max = Math.max(j_max,grid[i][j]);
            }
            ret += j_max;
        }
        return ret;
    }
}
