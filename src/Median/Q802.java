package Median;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            list.add(new ArrayList<>());
        }
        int[] in_degree = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                list.get(graph[i][j]).add(i);
                in_degree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < graph.length; i++){
            if(in_degree[i] == 0)
                q.add(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            for(int n : list.get(node)){
                if(--in_degree[n] == 0)
                    q.add(n);
            }
        }
        for(int i = 0; i < graph.length; i++){
            if(in_degree[i] == 0)
                res.add(i);
        }
        return res;
    }
}
