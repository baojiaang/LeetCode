package Median;

import java.util.ArrayList;
import java.util.List;

public class Q417 {
    int[][] dirs = {{-1,0}, {1,0},{0,1},{0,-1}};
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        List<List<Integer>> ret = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++){
            dfs(pacific, i ,0);
            dfs(atlantic,i, heights[0].length - 1);
        }
        for(int j = 0; j < heights[0].length; j++){
            dfs(pacific, 0, j);
            dfs(atlantic,heights.length - 1, j);
        }
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);list.add(j);
                    ret.add(list);
                }
            }
        }
        return ret;
    }

    public void dfs(boolean[][] canGo, int row, int col){
        if(canGo[row][col]){
            return;
        }
        canGo[row][col] = true;
        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if(nextRow < heights.length && nextRow >= 0 && nextCol < heights[0].length
                    && nextCol >= 0 && heights[nextRow][nextCol] >= heights[row][col]){
                dfs(canGo, nextRow, nextCol);
            }
        }
    }
}
