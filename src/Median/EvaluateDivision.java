package Median;
/*
* You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/evaluate-division
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 思路：并查集   还可用 bfs dfs
*
* */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int eqSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * eqSize);
        Map<String,Integer> hashMap = new HashMap<>(2*eqSize);  // 对变量进行映射，将string映射成数字
        int id = 0;
        for (int i = 0; i < eqSize; i++) {
            List<String> equation = equations.get(i);
            String s1 = equation.get(0);
            String s2 = equation.get(1);

            if(!hashMap.containsKey(s1)){
                hashMap.put(s1,id);
                id++;
            }
            if(!hashMap.containsKey(s2)){
                hashMap.put(s2,id);
                id++;
            }
            unionFind.union(hashMap.get(s1),hashMap.get(s2),values[i]);
        }

        int querySize = queries.size();
        double[] res = new double[querySize];
        for (int i = 0; i < querySize; i++) {
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(s1);
            Integer id2 = hashMap.get(s2);

            if (id1 == null || id2 == null){
                res[i] = -1.0d;
            }else{
                res[i] = unionFind.isConnected(id1,id2);
            }
        }
        return res;
    }
    private class UnionFind{
        private int[] parent;

        private double[] weight;
        public UnionFind(int n){
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x,int y, double value){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY){ // 根相同
                return;
            }

            parent[rootX] = rootY; // x的根指向y
            weight[rootX] = weight[y] * value / weight[x];
        }


        /*
        * 路径压缩
        * */
        public int find(int x){
            if(x!=parent[x]){
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return weight[x] / weight[y];
            }
            else{
                return -1d;
            }
        }
    }
}
