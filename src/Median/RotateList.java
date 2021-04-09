package Median;
/*
* 可以先连成环，找到断链点直接断链
* */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;

        int length = 0;
        // length
        for(ListNode cur = head; cur != null; cur = cur.next){
            length++;
        }
        int new_head_index = (length - k % length) % length;
        if(new_head_index == 0)
            return head;
        ListNode new_head = null;
        ListNode cur = head;
        ListNode pre = null;
        for(int i = 0; i < new_head_index; i++){
            pre = cur;
            cur = cur.next;
        }
        if(pre != null)
            pre.next = null;
        new_head = cur;

        // find tail
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = head;
        return new_head;
    }
}
