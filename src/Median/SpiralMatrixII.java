package Median;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int turn = 0;
        int row = 0, col = 0;
        for(int i = 1; i <= n*n ; i++){
            res[row][col] = i;
            int nextRow = row + directions[turn][0];
            int nextCol = col + directions[turn][1];

            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || res[nextRow][nextCol] != 0){
                turn = (turn+1) %4;
            }
            row += directions[turn][0];
            col += directions[turn][1];
        }
        return res;
    }
}
