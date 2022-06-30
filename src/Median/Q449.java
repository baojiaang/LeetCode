package Median;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q449 {
    public String serialize(TreeNode root){
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list.toString().substring(1, list.toString().length() - 1);
    }

    public TreeNode deserialize(String data){
        if(data.isEmpty()){
            return null;
        }
        String[] arr = data.split(", ");
        Stack<Integer> stack = new Stack<>();
        for(String num : arr){
            stack.push(Integer.parseInt(num));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    public void postOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    public TreeNode construct(int lower, int higher,Stack<Integer> stack){
        if(stack.isEmpty() || stack.peek() < lower || stack.peek() > higher){
            return null;
        }
        int val = stack.pop();
        TreeNode root = new TreeNode(val);
        root.right = construct(val,higher, stack);
        root.left = construct(lower, val, stack);
        return root;
    }
}
