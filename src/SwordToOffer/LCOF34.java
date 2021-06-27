package SwordToOffer;

import java.util.ArrayList;
import java.util.List;

public class LCOF34 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        back_track(root,target,new ArrayList<Integer>(),0);
        return res;
    }
    public void back_track(TreeNode root, int target, List<Integer> temp, int cur){
        if(root == null)
            return;
        if(cur == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(cur > target){
            return;
        }
        cur += root.val;
        temp.add(root.val);
        back_track(root.left,target,temp,cur);
        back_track(root.right,target,temp,cur);
        cur -= root.val;
        temp.remove(temp.size()-1);
    }
}
