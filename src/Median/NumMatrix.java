package Median;

public class NumMatrix {
    private int[][] sum;
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0)
            return;
        sum = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            int temp = 0;
            for(int j = 0; j < matrix[0].length; j++){
                temp += matrix[i][j];
                if(i != 0)
                    sum[i][j] = sum[i-1][j] + temp;
                else
                    sum[i][j] = temp;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r2 = sum[row2][col2];
        int r1 = 0;
        if(row1 != 0){
            r1 = sum[row1 - 1][col2];
        }
        int l1 = 0;
        if(row1 != 0 && col1 != 0){
            l1 = sum[row1 - 1][col1 - 1];
        }
        int l2 = 0;
        if(col1 != 0){
            l2 = sum[row2][col1 - 1];
        }
        return r2 - r1 - l2 + l1;
    }
}
