package Median;

public class Q669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode curRoot = findRoot(root, low, high);
        if(curRoot != null){
            curRoot.left = trimBST(curRoot.left, low, high);
            curRoot.right = trimBST(curRoot.right, low, high);
        }
        return curRoot;
    }
    public TreeNode findRoot(TreeNode root, int low, int high){
        if(root == null || (root.val >= low && root.val <= high)){
            return root;
        }
        if(root.val < low){
            root = findRoot(root.right, low ,high);
        }
        else if(root.val > high){
            root =findRoot(root.left, low ,high);
        }
        return root;
    }
}
