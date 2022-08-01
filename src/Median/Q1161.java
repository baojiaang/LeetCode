package Median;

import java.util.LinkedList;
import java.util.Queue;

public class Q1161 {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int lv = 0;
        int sum = Integer.MIN_VALUE;
        if(root != null){
            queue.add(root);
        }
        int curLv = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            curLv++;
            int curSum = 0;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                curSum += cur.val;
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            if(curSum > sum){
                lv = curLv;
                sum = curSum;
            }
        }
        return lv;
    }
}
