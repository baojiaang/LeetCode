package hard;

import java.util.*;

public class Q987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<My_TreeNode> q = new LinkedList<>();
        TreeMap<Integer,List<My_TreeNode>> map = new TreeMap<>(Integer::compareTo);
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        My_TreeNode r = new My_TreeNode(root,0,0);
        q.add(r);
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                My_TreeNode cur = q.poll();
                size--;
                List<My_TreeNode> list = map.getOrDefault(cur.col,new ArrayList<>());
                list.add(cur);
                map.put(cur.col,list);
                if(cur.t.left != null){
                    My_TreeNode cur_l = new My_TreeNode(cur.t.left,cur.row+1,cur.col-1);
                    q.add(cur_l);
                }
                if(cur.t.right != null){
                    My_TreeNode cur_r = new My_TreeNode(cur.t.right,cur.row+1,cur.col+1);
                    q.add(cur_r);
                }
            }
        }
        for(Map.Entry<Integer,List<My_TreeNode>> e : map.entrySet()){
            List<My_TreeNode> list = e.getValue();
            list.sort((My_TreeNode i1, My_TreeNode i2) -> (i1.row != i2.row ? i1.row - i2.row : i1.t.val - i2.t.val));
            List<Integer> l = new ArrayList<>();
            for(My_TreeNode node : list){
                l.add(node.t.val);
            }
            res.add(l);
        }
        return res;
    }
}
class My_TreeNode{
    TreeNode t;
    int row;
    int col;
    My_TreeNode(TreeNode t, int row ,int col){
        this.t = t;
        this.row = row;
        this.col = col;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}