package Median;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

 /*
 * preleft: 前序起点
 * preright：前序终点
 * inleft：中序起点
 * inright：中序终点
 *
 *
 *
 * */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preOrder, int inorder[]){
        int preLen = preOrder.length;
        int inLen = inorder.length;
        if(preLen != inLen)
            throw new RuntimeException("Incorrect input data");

        Map<Integer,Integer> map = new HashMap<>(preLen);

        for(int i= 0; i < inLen; i++){
            map.put(inorder[i],i);
        }

        return buildTree(preOrder, 0, preLen-1, map , 0 , inLen - 1);
    }
    public TreeNode buildTree(int[] preOrder, int preLeft, int preRight, Map<Integer,Integer> map,int inLeft, int inRight){
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }

        int rootVal = preOrder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int inOrderRootIndex = map.get(rootVal);

        root.left = buildTree(preOrder,preLeft+1,inOrderRootIndex-inLeft+preLeft,map,inLeft,inOrderRootIndex-1);
        root.right = buildTree(preOrder,inOrderRootIndex-inLeft+preLeft+1,preRight,map,inOrderRootIndex+1,inRight);

        return root;
    }
}
