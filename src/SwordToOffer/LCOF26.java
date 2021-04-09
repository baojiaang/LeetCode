package SwordToOffer;

import java.util.ArrayList;
import java.util.List;

public class LCOF26 {
    List<TreeNode> roots = new ArrayList<TreeNode>();
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null)
            return false;
        findRoot(A,B.val);
        for(int i = 0; i < roots.size(); i++){
            TreeNode start = roots.get(i);
            if(two_travel(start,B))
                return true;
        }
        return false;
    }
    public void findRoot(TreeNode root, int val){
        if(root == null) return;
        if(root.val == val) {
            roots.add(root);
        }
        findRoot(root.left,val);
        findRoot(root.right,val);
    }
    public boolean two_travel(TreeNode a, TreeNode b){
        if( a == null  && b != null)
            return false;
        else if( a == null && b == null)
            return true;
        else if( a != null && b == null){
            return true;
        }
        else if( a != null && b != null){
            if( a.val != b.val ){
                return false;
            }
            boolean left = two_travel(a.left,b.left);
            boolean right = two_travel(a.right,b.right);
            return left && right;
        }
        return true;
    }
}
