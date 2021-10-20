package Median;

public class Q789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis = Math.abs(target[0]) + Math.abs(target[1]);
        for(int i = 0; i < ghosts.length; i++){
            if((Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1])) <= dis)
                return false;
        }
        return true;
    }
}
