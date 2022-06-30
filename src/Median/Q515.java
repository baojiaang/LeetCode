package Median;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q515 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = queue.peek().val;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.val > max){
                    max = cur.val;
                }
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
