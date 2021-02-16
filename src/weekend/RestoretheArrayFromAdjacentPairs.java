//package weekend;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//
//public class RestoretheArrayFromAdjacentPairs {
//    public int[] restoreArray(int[][] adjacentPairs) {
//        HashMap<Integer, ArrayList<Integer>> nodes = new HashMap<>();
//        for(int i=0;i<adjacentPairs.length;i++){
//            int first = adjacentPairs[i][0];
//            int second = adjacentPairs[i][1];
//            if(!nodes.containsKey(first)){
//                ArrayList<Integer> adj = new ArrayList<>();
//                adj.add(second);
//                nodes.put(first,adj);
//            }
//            else{
//                ArrayList<Integer> adj = nodes.get(first);
//                adj.add(second);
//                nodes.put(first,adj);
//            }
//            if(!nodes.containsKey(second)){
//                ArrayList<Integer> adj = new ArrayList<>();
//                adj.add(first);
//                nodes.put(second,adj);
//            }
//            else{
//                ArrayList<Integer> adj = nodes.get(second);
//                adj.add(first);
//                nodes.put(second,adj);
//            }
//        }
//        int head = 0;
//        for (Integer key:nodes.keySet()
//             ) {
//            ArrayList<Integer> adj = nodes.get(key);
//            if(adj.size()==1) {
//                head = key;
//                break;
//            }
//        }
//
//    }
//
//}
