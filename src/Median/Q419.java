package Median;

public class Q419 {
    public int countBattleships(char[][] board) {
        int ret = 0;
        int[][] toDirections = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    boolean flag = true;
                    board[i][j] = 'V';
                    for(int[] direction: toDirections){
                        if(isValidIndex(i + direction[0] , j + direction[1], board)){
                            if(board[i + direction[0]][j + direction[1]] == 'V'){
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(flag){
                        ret++;
                    }
                }
            }
        }
        return ret;
    }
    public boolean isValidIndex(int i, int j,char[][] board){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        Q419 q = new Q419();
        System.out.println(q.countBattleships(board));
    }
}
