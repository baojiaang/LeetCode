package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTree {
    TreeNode xf;
    TreeNode yf;
    int l1,l2;
    public boolean isCousins(TreeNode root, int x, int y) {
        check(root,x,y);
        if(!xf.equals(yf) && l1 != l2)
            return true;
        return false;
    }
    public void check(TreeNode root, int x, int y){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int l = -1;
        while(!q.isEmpty()){
            int size = q.size();
            l++;
            for(int i = 0; i < size; i++){
                TreeNode t = q.poll();
                if(t.left != null){
                    if(t.left.val == x){
                        System.out.println("1");
                        xf = t;
                        l1 = l;
                    }
                    q.add(t.left);
                }
                if(t.right != null){
                    if(t.right.val == y){
                        System.out.println("1");
                        yf = t;
                        l2 = l;
                    }
                    q.add(t.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        CousinsinBinaryTree c = new CousinsinBinaryTree();

    }
}
