package hard;



public class ReverseNodesinkGroup {
    public ListNode reverseKgroup(ListNode head, int k){
        ListNode dummy = new ListNode(0); // 哑节点
        dummy.next = head; // 结果
        ListNode pre = dummy;

        while(head != null){
            ListNode end = pre;
            // 吃进k个
            for(int i = 0; i < k; i++){
                end = end.next;
                if(end == null)
                    return dummy.next;
            }
            ListNode next = end.next;
            ListNode[] t_res = reverse(head,end);

            head = t_res[0];
            end = t_res[1];

            pre.next = head;
            end.next = next;
            pre = end;
            head = end.next;
        }
        return dummy.next;
    }
    public ListNode[] reverse(ListNode start, ListNode end){
        ListNode pre = end.next;
        ListNode cur = start;

        while(pre != end){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{end,start};
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}