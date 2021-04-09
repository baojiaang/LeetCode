package SwordToOffer;

import java.util.ArrayList;
import java.util.List;

public class LCOF12 {
    boolean[][] visited;
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board,word,i,j,new ArrayList<>(),0);
                if(flag)
                    return true;
            }
        }
        return flag;
    }
    public boolean dfs(char[][] borad,String word,int x, int y, List<Character> temp,int start){
        visited[x][y] = true;
        if(borad[x][y] == word.charAt(start)){
        temp.add(borad[x][y]);
        if(temp.size() == word.length()) {
            flag = true;
            return true;
        }
        if(x-1 >= 0 && visited[x-1][y] == false && borad[x-1][y] == word.charAt(start+1) ){
            if(this.flag == false){
            dfs(borad,word,x-1,y,temp,start+1);
            }

        }
        if(x+1 < borad.length && visited[x+1][y] == false && borad[x+1][y] == word.charAt(start+1)  ){
            if(this.flag == false)
                dfs(borad,word,x+1,y,temp,start+1);
        }
        if(y-1 >= 0 && visited[x][y-1] == false && borad[x][y-1] == word.charAt(start+1) ){
            if(this.flag == false)
                dfs(borad,word,x,y-1,temp,start+1);
        }
        if(y+1 < borad[0].length && visited[x][y+1] == false && borad[x][y+1] == word.charAt(start+1) ){
            if(this.flag == false)
                dfs(borad,word,x,y+1,temp,start+1);
        }
        temp.remove(temp.size()-1);
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] borad = {{'b','a'},{'b','b'}};
        LCOF12 l = new LCOF12();
        l.exist(borad,"ab");
    }
}
