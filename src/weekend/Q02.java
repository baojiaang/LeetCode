package weekend;

import java.util.*;

public class Q02 {
    class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Pos pos = (Pos) obj;
            if (pos.x == this.x && pos.y == this.y) {
                return true;
            } else {
                return false;
            }


        }
    }
    Set<Pos> list = new TreeSet<>((Pos a, Pos b) -> (a.x != b.x ? a.x - b.x : a.y - b.y));
    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        int n = terrain.length;
        int m = terrain[0].length;
        int startX = position[0];
        int startY = position[1];
        boolean[][] visited = new boolean[n][m];
        visited[startX][startY] = true;
        dfs(startX,startY,terrain,obstacle,visited,1);

        int size = list.size();
        int[][] ret = new int[size][2];
        int i = 0;
        for(Pos pos : list){
            ret[i][0] = pos.x;
            ret[i][1] = pos.y;
            i++;
        }
        return ret;
    }
    public void dfs(int x, int y,int[][] terrain, int[][] obstacle,boolean[][] visited,int speed){
        if(x - 1 >= 0 && visited[x-1][y] == false){
            int change = terrain[x][y] - terrain[x-1][y] - obstacle[x-1][y];
            if( speed + change >= 0){
                if(speed + change == 1 ){
                    list.add(new Pos(x-1,y));
                }
                visited[x-1][y] = true;
                dfs(x-1,y,terrain,obstacle,visited,speed+change);
                visited[x-1][y] = false;
            }
        }
        if(x + 1 < visited.length && visited[x+1][y] == false){
            int change = terrain[x][y] - terrain[x+1][y] - obstacle[x+1][y];
            if( speed + change >= 0 ){
                if(speed + change == 1 ){
                    list.add(new Pos(x+1,y));
                }
                visited[x+1][y] = true;
                dfs(x+1,y,terrain,obstacle,visited,speed+change);
                visited[x+1][y] = false;
            }
        }
        if(y - 1 >= 0 && visited[x][y-1] == false){
            int change = terrain[x][y] - terrain[x][y-1] - obstacle[x][y-1];
            if( speed + change >= 0){
                if(speed + change == 1 ){
                    list.add(new Pos(x,y-1));
                }
                visited[x][y-1] = true;
                dfs(x,y-1,terrain,obstacle,visited,speed+change);
                visited[x][y-1] = false;
            }
        }
        if(y + 1 < visited[0].length && visited[x][y+1] == false){
            int change = terrain[x][y] - terrain[x][y+1] - obstacle[x][y+1];
            if( speed + change >= 0){
                if(speed + change == 1 ){
                    list.add(new Pos(x,y+1));
                }
                visited[x][y+1] = true;
                dfs(x,y+1,terrain,obstacle,visited,speed+change);
                visited[x][y+1] = false;
            }
        }
    }
}
