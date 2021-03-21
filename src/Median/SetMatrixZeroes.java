package Median;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(Integer i : row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for(Integer j : col){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][j] = 0;
            }
        }
    }
}
