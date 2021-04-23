package Median;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/*
* 左到右   头出 尾进 左右
* 右到左    尾出 头进 右左
* */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int turn = 0;
        Deque<TreeNode> dq = new LinkedList<TreeNode>();

        List<List<Integer>> res = new ArrayList<>();

        if(root != null)
            dq.offerFirst(root);
        while(!dq.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(turn % 2 == 0){
                int size = dq.size();
                for(int i = 0; i < size; i++){
                    TreeNode t= dq.pollFirst();
                    list.add(t.val);
                    if(t.left != null){
                        dq.offerLast(t.left);
                    }
                    if(t.right != null){
                        dq.offerLast(t.right);
                    }
                }
            }
            else{
                int size = dq.size();
                for(int i = 0; i < size; i++){
                    TreeNode t = dq.pollLast();
                    list.add(t.val);
                    if(t.right != null){
                        dq.offerFirst(t.right);
                    }
                    if(t.left != null){
                        dq.offerFirst(t.left);
                    }
                }
            }
            res.add(list);
            turn++;
        }
        return res;
    }
}
