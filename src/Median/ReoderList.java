package Median;
/*
* 快慢指针找中点，分成前后两个链表
* 反转后面链表
* 合并链表
* */

public class ReoderList {
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode fast = head;
        ListNode slow = head;
        for(; fast.next !=null && fast.next.next !=null;){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 =head;
        ListNode l2 =slow.next;
        slow.next = null;
        l2 = reverse(l2);
        merge(l1,l2);
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode tempNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNext;
        }
        return pre;
    }
    public void merge(ListNode head1, ListNode head2){
        ListNode head1_temp = null;
        ListNode head2_temp = null;
        while(head1 !=null && head2 !=null){
            head1_temp = head1.next;
            head2_temp = head2.next;

            head1.next = head2;
            head1 = head1_temp;

            head2.next = head1;
            head2 = head2_temp;
        }
    }
}
