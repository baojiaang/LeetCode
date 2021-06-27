package SwordToOffer;

import java.util.*;

public class LCOF32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        q.addFirst(root);
        int flag = 0;
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> level = new ArrayList<>();
            if(flag % 2 == 0){
                for(int i = 0; i < len; i++){
                    TreeNode t = q.pollFirst();
                    level.add(t.val);
                    if(t.left != null)
                        q.addLast(t.left);
                    if(t.right != null)
                        q.addLast(t.right);
                }
            }
            else{
                for(int i = 0; i < len; i++){
                    TreeNode t = q.pollLast();
                    level.add(t.val);
                    if(t.left != null)
                        q.addFirst(t.right);
                    if(t.right != null)
                        q.addFirst(t.left);
                }
            }
            res.add(level);
            flag++;
        }
        return res;
    }
}
