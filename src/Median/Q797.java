package Median;

import java.util.ArrayList;
import java.util.List;

public class Q797 {
    List<List<Integer>> l = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph,0,graph.length-1,new ArrayList<>());
        return l;
    }
    public void dfs(int[][] graph,int cur,int aim,List<Integer> list){
        int[] nodes = graph[cur];
        list.add(cur);
        if(cur == aim){
            l.add(new ArrayList<>(list));
        }
        for(int node : nodes){
            dfs(graph,node,aim,list);
        }
        list.remove(list.size()-1);
    }
}
