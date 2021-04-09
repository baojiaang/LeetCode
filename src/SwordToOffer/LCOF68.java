package SwordToOffer;

public class LCOF68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.equals(p) || root.equals(q) ){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        if(left != null && right != null){
            return root;
        }
        if(left == null && right == null){
            return null;
        }

        return left == null ? right : left;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}