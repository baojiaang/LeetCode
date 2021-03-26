package Median;
/*
* 双指针， 用快慢指针找相遇点，找到相遇点后，一点从起始点开始，另一点从相遇点开始，两点相遇时即为环的入口
* */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;

        while(fast.next!= null && fast.next.next != null && slow.next!= null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast.equals(slow)){
                meet = fast;
                break;
            }
        }
        ListNode start = head;
        if(meet != null) {
            while (!start.equals(meet)) {
                start = start.next;
                meet = meet.next;
            }
        }
        return meet;
    }
}
