package Median;

import java.util.*;

public class Q433 {
    HashMap<String,List<String>> map = new HashMap<String, List<String>>();
    public int minMutation(String start, String end, String[] bank) {
        List<String> one = new ArrayList<>();
        for(String s : bank){
            if(one_change(start, s)){
                one.add(s);
            }
        }
        map.put(start, one);
        for(int i = 0; i < bank.length; i++){
            List<String> nei = new ArrayList<>();
            for(int j = 0; j < bank.length; j++){
                if(j != i && one_change(bank[i], bank[j])){
                    nei.add(bank[j]);
                }
            }
            map.put(bank[i], nei);
        }
        HashSet<String> visited = new HashSet<>();
        return bfs(start, end, visited);
    }
    public boolean one_change(String from, String to){
        int count = 0;
        for(int i = 0; i < from.length(); i++){
            if(from.charAt(i) != to.charAt(i)){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }
    public int bfs(String start, String end, HashSet<String> visited){
        int step = 0;
        if(start.equals(end)){
            return 0;
        }
        List<String> nei = map.get(start);
        Queue<String> queue = new LinkedList<>();
        for(String s : nei){
            queue.add(s);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            for(int i = 0; i < size; i++){
                String s = queue.poll();
                visited.add(s);
                if(s.equals(end)){
                    return step;
                }
                else{
                    List<String> next_nei = map.get(s);
                    for(String n_s : next_nei){
                        if(!visited.contains(n_s)) {
                            queue.add(n_s);
                        }
                    }
                }
            }
        }
        return -1;
    }

}
