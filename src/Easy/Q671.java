package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Q671 {
    int second = Integer.MAX_VALUE;
    boolean flag = false;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        int first = root.val;
        second = first;
        pre_order(root,first);
        if(flag == true)
            return second;
        else
            return -1;
    }

    public void pre_order(TreeNode root,int first){
        if(root == null)
            return;
        if(root.val > first && root.val <= second){
            flag = true;
            second = Math.min(second,root.val);
        }
        pre_order(root.left,first);
        pre_order(root.right,first);
    }
}
