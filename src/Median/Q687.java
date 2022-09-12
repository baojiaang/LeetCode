package Median;

public class Q687 {
    int ret = 0;
    public int longestUnivaluePath(TreeNode root) {
        postOrder(root);
        return ret;
    }
    public int postOrder(TreeNode root){
        if(root == null){
           return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int l = 0;
        int r = 0;
        if(root.left != null && root.left.val == root.val){
            l = left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            r = right + 1;
        }
        ret = Math.max(l + r,ret);
        return Math.max(l, r);
    }

}
