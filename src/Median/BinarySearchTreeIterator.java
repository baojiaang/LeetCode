package Median;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {

}
class BSTIterator {
    private List<Integer> res;
    private int index;
    private int length;
    public BSTIterator(TreeNode root) {
        this.res = new ArrayList<>();
        inorder_travel(root);
        this.index = -1;
        this.length = res.size();
    }

    public int next() {
        index++;
        return res.get(index);
    }

    public boolean hasNext() {
        return index+1 < length;
    }
    public void inorder_travel(TreeNode root){
        if(root != null) {
            inorder_travel(root.left);
            res.add(root.val);
            inorder_travel(root.right);
        }
    }
}
