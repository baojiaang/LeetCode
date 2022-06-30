package Median;

import java.util.ArrayList;
import java.util.List;

public class Q1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preOrder(root1, list1);
        preOrder(root2, list2);
        List<Integer> ret = merge(list1, list2);
        return ret;

    }
    public void preOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        preOrder(root.left, list);
        System.out.println(root.val);
        list.add(root.val);
        preOrder(root.right,list);
    }
    public List<Integer> merge(List<Integer> list1, List<Integer> list2){
        List<Integer> ret = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        while(idx1 < list1.size() && idx2 < list2.size()){
            if(list1.get(idx1) <= list2.get(idx2)){
                ret.add(list1.get(idx1));
                idx1++;
            }
            else{
                ret.add(list2.get(idx2));
                idx2++;
            }
        }
        for(int i = idx1; i < list1.size(); i++){
            ret.add(list1.get(i));
        }
        for(int i = idx2; i < list2.size(); i++){
            ret.add(list2.get(i));
        }
        return ret;
    }
}
