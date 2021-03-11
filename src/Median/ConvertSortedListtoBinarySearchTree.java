package Median;
/*
* Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 快慢指针找中点  然后递归建树
* */
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);

        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        // 找中点
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(slow.next);
        TreeNode root = new TreeNode(slow.val,left,right);

        return  root;
    }
}
