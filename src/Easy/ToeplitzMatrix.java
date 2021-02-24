package Easy;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
//    public boolean check(int[][] matrix, int i, int j, int val,boolean flag){
//        int rowLength = matrix[0].length;
//        int colLength = matrix.length;
//        if(i < colLength && j < rowLength){
//            if(matrix[i][j] == val)
//                check(matrix,i+1,j+1,val,flag);
//            else {
//                flag = false;
//                return flag;
//            }
//        }
//        return flag;
//    }

    public static void main(String[] args) {
        ToeplitzMatrix t = new ToeplitzMatrix();
        int[][] test = {{1,2,},{2,2}};
        System.out.println(t.isToeplitzMatrix(test));
    }
}
