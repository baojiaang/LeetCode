package Median;

public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = postOrder(root,p,q);
        return ret;
    }

    public TreeNode postOrder(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftFind = postOrder(root.left, p, q);
        TreeNode rightFind = postOrder(root.right, p, q);
        if(leftFind == null){
            return rightFind;
        }
        if(rightFind == null){
            return leftFind;
        }
        return root;
    }
}
