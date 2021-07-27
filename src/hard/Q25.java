package hard;

public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null){
            ListNode tail = pre;
            for(int i = 0; i < k; i++){
                tail = tail.next;
                if(tail == null)
                    return dummy.next;
            }
            ListNode next = tail.next;
            ListNode[] r = reverse(head,tail,k);
            head = r[0];
            tail = r[1];

            pre.next = head;
            tail.next = next;

            pre = tail;
            head = next;
        }
        return dummy.next;
    }
    public ListNode[] reverse(ListNode head, ListNode tail, int k){
        ListNode pre = tail.next;
        ListNode cur = head;
        for(int i = 0; i < k; i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail,head};
    }
}
