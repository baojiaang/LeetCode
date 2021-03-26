package Easy;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode cur = head;
        HashSet<Integer> set = new HashSet<>();
        Deque<ListNode> dq = new LinkedList<>();
        while(cur != null){
            if(!set.contains(cur.val)){
                set.add(cur.val);
                dq.addLast(new ListNode(cur.val));
            }
            cur = cur.next;
        }
        head = dq.pollFirst();
        cur = head;
        while(!dq.isEmpty()){
            cur.next = dq.pollFirst();
            cur = cur.next;
        }
        return head;
    }
}
