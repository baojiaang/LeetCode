package Median;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        Deque<ListNode> dq = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head;
        while( cur != null ){
            if(set.contains(cur.val)){
                while(true){
                    ListNode pre = dq.peekLast();
                    if(pre == null)
                        break;
                    if(pre.val != cur.val) {
                        break;
                    }
                    dq.pollLast();
                }
            }
            else{
                set.add(cur.val);
                dq.addLast(new ListNode(cur.val));
            }
            cur = cur.next;
        }
        head = dq.pollFirst();
        cur = head;
        while(dq.size() > 0){
            cur.next = dq.pollFirst();
            cur = cur.next;
        }
        return head;
    }
//    public ListNode findHead(ListNode head){
//        if(head == null || head.next == null)
//            return head;
//        while(head != null){
//            if(head.next != null){
//                if(head.next.val != head.val){
//                    return head;
//                }
//            }
//            head = head.next;
//        }
//        return null;
//    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode s = new ListNode(2);
        ListNode s1 = new ListNode(2);
     //   ListNode s2 = new ListNode(3);
        s.next = s1;
      //  s1.next = s2;
        head.next = s;
        RemoveDuplicatesfromSortedListII r = new RemoveDuplicatesfromSortedListII();
        r.deleteDuplicates(head);
    }
}
