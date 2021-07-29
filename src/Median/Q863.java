package Median;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Q863 {
    HashMap<Integer,TreeNode> par = new HashMap<>();
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        find_parents(root);
        find_ans(target,null,0,k);
        return res;
    }
    public void find_parents(TreeNode root){
        if(root.left != null){
            par.put(root.left.val,root);
            find_parents(root.left);
        }
        if(root.right != null){
            par.put(root.right.val,root);
            find_parents(root.right);
        }
    }
    public void find_ans(TreeNode cur,TreeNode from,int depth, int k){
        if(depth == k)
            res.add(cur.val);
        if(depth < k){
            if(cur.left != null && cur.left != from){
                find_ans(cur.left,cur,depth+1,k);
            }
            if(cur.right != null && cur.right != from){
                find_ans(cur.right,cur,depth+1,k);
            }
            if(par.get(cur.val) != null && par.get(cur.val) != from){
                find_ans(par.get(cur.val),cur,depth+1,k);
            }
        }
    }
}
