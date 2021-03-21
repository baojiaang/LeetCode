package Median;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        int turn = 0;
        int row = 0, col = 0;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0; i < m*n ; i++){
            res.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[turn][0];
            int nextCol = col + directions[turn][1];

            if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol] == true){
                turn = (turn+1) %4;
            }
            row += directions[turn][0];
            col += directions[turn][1];
        }
        return res;
    }
}
