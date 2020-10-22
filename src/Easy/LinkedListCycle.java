package Easy;
/*
*   快慢指针， 快的每次移动两个， 慢的移动一个， 如果快的追上慢的， 说明有环
*
* */
class ListNode {
    int val;
      ListNode next;
      ListNode(int x) {
         val = x;
         next = null;
      }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        else{
            ListNode slow = head;
            ListNode fast = head.next;
            while(slow!=fast){
               if(fast == null || fast.next == null){
                   return false;
               }
               slow = slow.next;
               fast = fast.next.next;
            }
            return true;

        }
    }
}
