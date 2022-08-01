package Median;

public class Q814 {
    public TreeNode pruneTree(TreeNode root) {
        root = postOrder(root);
        return root;
    }

    public TreeNode postOrder(TreeNode root){
        if(root == null){
            return null;
        }
        root.left = postOrder(root.left);
        root.right = postOrder(root.right);
        if(root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }
}
