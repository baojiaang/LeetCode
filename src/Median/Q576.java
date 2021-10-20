package Median;

public class Q576 {
//    int res = 0;
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        dfs(m,n,maxMove,startRow,startColumn);
//        return res;
//    }
//    public void dfs(int m,int n,int cur, int cur_row, int cur_col){
//        if(cur < 1)
//            return;
//        if(cur_row < 0 || cur_row >= m || cur_col < 0 || cur_col >= n){
//            return;
//        }
//        if(cur_row == 0){
//            res = (res + 1) % 1000000007;
//        }
//        if(cur_col == 0){
//            res = (res + 1) % 1000000007;
//        }
//        if(cur_row == m - 1){
//            res = (res + 1) % 1000000007;
//        }
//        if(cur_col == n - 1){
//            res = (res + 1) % 1000000007;
//        }
//        dfs(m,n,cur-1,cur_row-1,cur_col);
//        dfs(m,n,cur-1,cur_row+1,cur_col);
//        dfs(m,n,cur-1,cur_row,cur_col+1);
//        dfs(m,n,cur-1,cur_row,cur_col-1);
//    }
public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    final int MOD = 1000000007;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int outCounts = 0;
    int[][][] dp = new int[maxMove + 1][m][n];
    dp[0][startRow][startColumn] = 1;
    for (int i = 0; i < maxMove; i++) {
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                int count = dp[i][j][k];
                if (count > 0) {
                    for (int[] direction : directions) {
                        int j1 = j + direction[0], k1 = k + direction[1];
                        if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                            dp[i + 1][j1][k1] = (dp[i + 1][j1][k1] + count) % MOD;
                        } else {
                            outCounts = (outCounts + count) % MOD;
                        }
                    }
                }
            }
        }
    }
    return outCounts;
}

    public static void main(String[] args) {
        Q576 q = new Q576();
        System.out.println(q.findPaths(8,50,23,5,26));
    }
}
