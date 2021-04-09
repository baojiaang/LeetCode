package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    Queue<TreeNode> q = new LinkedList<>();
    int height = 0;
    public int minDepth(TreeNode root) {
        if(root != null){
            q.add(root);
            while(q.size() > 0){
                int size = q.size();
                height++;
                for(int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (node.left == null && node.right == null) {
                        return height;
                    }
                    if(node.left != null)
                        q.add(node.left);
                    if(node.right != null)
                        q.add(node.right);
                }
            }
        }
        return 0;
    }
}
