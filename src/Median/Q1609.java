package Median;

import java.util.*;

public class Q1609 {
    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addFirst(root);
        int l = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> level = new ArrayList<>(size);
            if (l % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = dq.pollFirst();
                    level.add(node.val);
                    if (node.left != null) {
                        dq.addLast(node.left);
                    }
                    if (node.right != null) {
                        dq.addLast(node.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = dq.pollLast();
                    level.add(node.val);
                    if (node.right != null) {
                        dq.addFirst(node.right);
                    }
                    if (node.left != null) {
                        dq.addFirst(node.left);
                    }
                }
            }
            l++;
            list.add(level);
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> levelList = list.get(i);
            if (i % 2 == 0) {
                int oddPre = Integer.MIN_VALUE;
                for (int num : levelList) {
                    if (num <= oddPre || num % 2 == 0) {
                        return false;
                    }
                    oddPre = num;
                }
            } else {
                int evenPre = Integer.MIN_VALUE;
                for (int num : levelList) {
                    if (num <= evenPre || num % 2 == 1) {
                        return false;
                    }
                    evenPre = num;
                }
            }
        }
        return true;
    }
}
