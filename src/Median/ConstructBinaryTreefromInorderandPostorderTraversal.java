package Median;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        int n = inorder.length;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        TreeNode root = build(0,n-1,0,n-1);
        return root;
    }
    public TreeNode build(int post_left, int post_right, int in_left, int in_right){
        // 边界
        if(post_left > post_right || in_left > in_right){
            return null;
        }

        TreeNode root = new TreeNode(postorder[post_right]);
        int in_root = map.get(root.val);

        root.left = build(post_left,post_left+in_root-in_left-1,in_left,in_left+in_root-in_left-1);
        root.right = build(post_left+in_root-in_left,post_right-1,in_root+1,in_right);

        return root;
    }
}
