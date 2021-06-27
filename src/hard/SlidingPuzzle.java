package hard;

import java.util.*;

public class SlidingPuzzle {
    int[][] neighbour = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
    public int slidingPuzzle(int[][] board) {

        StringBuilder sb =new StringBuilder();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String end = "123450";
        int step = 0;
        if(start.equals(end))
            return 0;

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        Set<String> seen = new HashSet<String>();
        seen.add(start);
        while(!queue.isEmpty()){
            step++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String status = queue.poll();
                for(String next_status : next_status(status)){
                    if(!seen.contains(next_status)){
                        if(next_status.equals(end)){
                            return step;
                        }
                        queue.add(next_status);
                        seen.add(status);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> next_status(String s){
        int idx = s.indexOf('0');
        int[] nei = neighbour[idx];
        List<String> list = new ArrayList<>();
        for(int x : nei){
            char[] arr = s.toCharArray();
            String next = swap(arr, x , idx);
            list.add(next);
        }
        System.out.println(list);
        return list;
    }
    public String swap(char[] arr, int x, int y){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return new String(arr);
    }

    public static void main(String[] args) {
        SlidingPuzzle s = new SlidingPuzzle();
        int[][] b = {{1,2,3},{4,0,5}};
        System.out.println(s.slidingPuzzle(b));
    }
}
